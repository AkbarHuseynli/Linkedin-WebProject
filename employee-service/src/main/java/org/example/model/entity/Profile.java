package org.example.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

//    @Column(name = "email", nullable = false)
    String email;

//    @Column(name = "biography")
    String biography;

    String jobTitle;

//    @Column(name = "degreeOfEducation")
    String degreeOfEducation;

//    @Column(name = "university")
    String university;

//    @Column(name = "grade")
    int grade;

//    @Column(name = "yearOfWorkExperience")
    int yearOfWorkExperience;

    boolean status;

    @OneToOne(mappedBy = "profile")
    //    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    Employee employee;
}
