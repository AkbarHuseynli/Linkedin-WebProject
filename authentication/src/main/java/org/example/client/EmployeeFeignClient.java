package org.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "employeeFeignClient",url = "/employee")
public interface EmployeeFeignClient {
    @PostMapping(path = "/register")
    public void register(@RequestBody EmployeeClient employeeClient);
}
