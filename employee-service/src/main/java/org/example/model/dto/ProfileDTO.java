package org.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.entity.Employee;

import javax.persistence.OneToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    String email;

    String biography;

    String degreeOfEducation;

    String university;

    int grade;

    int yearOfWorkExperience;

    boolean status;
}
