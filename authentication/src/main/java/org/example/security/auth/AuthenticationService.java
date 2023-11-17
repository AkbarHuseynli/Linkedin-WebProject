package org.example.security.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.client.EmployeeFeignClient;
import org.example.model.dto.CompanyRequest;
import org.example.model.entity.ERole;
import org.example.model.dto.EmployeeRequest;
import org.example.model.entity.Role;
import org.example.model.entity.User;
import org.example.security.config.JwtService;
import org.example.service.RoleService;
import org.example.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private final RoleService roleService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeFeignClient employeeFeignClient;

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        return generateAndPassToken(userDetailsService.loadUserByUsername(request.getUsername()));
    }

    private AuthResponse generateAndPassToken(UserDetails user) {
        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken);
    }

    public AuthResponse registerCompany(CompanyRequest request) {
        Role newRole = roleService.findByRoleName(ERole.COMPANY);
        User user = User.builder()
                .roles(Set.of(newRole))
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .build();

        userService.save(user);
        return generateAndPassToken(user);
    }

    public AuthResponse registerEmployee(EmployeeRequest request) {
        Role newRole = roleService.findByRoleName(ERole.EMPLOYEE);
        User user = User.builder()
                .roles(Set.of(newRole))
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .build();
        userService.save(user);
        employeeFeignClient.registerEmployee(request);
        return generateAndPassToken(user);
    }
}
