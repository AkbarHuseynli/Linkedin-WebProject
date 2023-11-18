package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.dto.ProfileDTO;
import org.example.model.entity.Employee;
import org.example.model.entity.Profile;
import org.example.repository.IEmployeeRepository;
import org.example.repository.IProfileRepository;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final IProfileRepository iProfileRepository;
    private final IEmployeeRepository iEmployeeRepository;

    public void updateProfile(int employeeId, ProfileDTO profileDTO) {
        Employee employee = iEmployeeRepository.getById(employeeId);

        Profile profile = Profile.builder()
                .yearOfWorkExperience(profileDTO.getYearOfWorkExperience())
                .grade(profileDTO.getGrade())
                .biography(profileDTO.getBiography())
                .email(profileDTO.getEmail())
                .degreeOfEducation(profileDTO.getDegreeOfEducation())
                .university(profileDTO.getUniversity())
                .employee(employee)
                .build();
            //**mapstruct

        iProfileRepository.save(profile);

    }
}
