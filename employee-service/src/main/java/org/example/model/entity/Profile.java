package org.example.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "username", nullable = false, unique = true)
    String username;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "biography")
    String biography;

    @Column(name = "degreeOfEducation")
    String degreeOfEducation;

    @Column(name = "university")
    String university;

    @Column(name = "grade")
    int grade;

    @Column(name = "yearOfWorkExperience")
    int yearOfWorkExperience;

//    @OneToOne(mappedBy = "profile")
//    User user;
}
