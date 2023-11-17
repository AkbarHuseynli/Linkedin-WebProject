package org.example.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.CompanyRequest;
import org.example.model.dto.EmployeeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register/company")
    public ResponseEntity<AuthResponse> registerCompany(@RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(authService.registerEmployee(request));
    }
    @PostMapping("/register/employee")
    public ResponseEntity<AuthResponse> registerEmployee(@RequestBody CompanyRequest request) {
        return ResponseEntity.ok(authService.registerCompany(request));
    }



}
