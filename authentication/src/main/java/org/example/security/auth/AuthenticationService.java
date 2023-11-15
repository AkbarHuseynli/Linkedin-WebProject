package org.example.security.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.ERole;
import org.example.model.RegisterDTO;
import org.example.model.Role;
import org.example.model.User;
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
@Transactional(dontRollbackOn = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final RestTemplate restTemplate;
    private final UserService userService;
    private final RoleService roleService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterDTO request) {
        Role newRole = null;
        if (request.getTypeOfUser().equalsIgnoreCase("company")) {
            newRole = roleService.findByRoleName(ERole.COMPANY);
        } else if (request.getTypeOfUser().equalsIgnoreCase("employee")) {
            newRole = roleService.findByRoleName(ERole.EMPLOYEE);
        } else {
            throw new IllegalArgumentException("User type needs to be claimed!");
        }
        User user = User.builder()
                .roles(Set.of(newRole))
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .build();

        userService.save(user);
        return generateAndPassToken(user);

    }

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

}
