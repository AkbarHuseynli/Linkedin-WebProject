package org.example.model.client;

import org.example.model.dto.EmployeeRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="employeeFeignClient", url = "https://localhost:8010/employees")
public interface EmployeeFeignClient {
    @PostMapping
    void registerEmployee(@RequestBody EmployeeRequest employeeRequest);

}
