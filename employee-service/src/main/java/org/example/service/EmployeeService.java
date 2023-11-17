package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.EmployeeRequest;
import org.example.model.entity.Employee;
import org.example.model.entity.Profile;
import org.example.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private IEmployeeRepository iEmployeeRepository;

    public void register(EmployeeRequest employeeRequest) {
        Profile newProfile = Profile.builder().status(true).build();
        Employee newEmployee = Employee.builder()
                .fullname(employeeRequest.getFullname())
                .age(employeeRequest.getAge())
                .profile(newProfile).build();
        iEmployeeRepository.save(newEmployee);
    }

}
