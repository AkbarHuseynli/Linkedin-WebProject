package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.VacancyDTO;
import org.example.model.dto.JobDTO;
import org.example.service.CompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;
    @PostMapping("/vacancy/announce")
    public void addVacancy(@RequestBody VacancyDTO vacancyDTO, @PathVariable JobDTO jobDTO){

    }

}
