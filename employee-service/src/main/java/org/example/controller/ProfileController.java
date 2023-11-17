package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.ProfileDTO;
import org.example.service.ProfileService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/profiles")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    @PreAuthorize("hasRole('EMPLOYEE')")
    @PostMapping("/update/{employeeId}")
    public void updateProfile(@PathVariable int employeeId, @RequestBody ProfileDTO profileDTO){
        profileService.updateProfile(employeeId, profileDTO);
    }

}
