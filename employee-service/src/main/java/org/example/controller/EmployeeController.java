package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.EmployeeRequest;
import org.example.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private EmployeeService employeeservice;

    @PostMapping(path = "/register")
    public void register(@RequestBody EmployeeRequest employeeRequest) {
        employeeservice.register(employeeRequest);
    }
}
