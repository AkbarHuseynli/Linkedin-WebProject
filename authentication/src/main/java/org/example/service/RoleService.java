package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.entity.ERole;
import org.example.model.entity.Role;
import org.example.repository.RoleRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByRoleName(ERole role) {
        return roleRepository.findByRoleName(role)
                .orElseThrow(() -> new UsernameNotFoundException("Role couldnt be found!"));
    }

}
