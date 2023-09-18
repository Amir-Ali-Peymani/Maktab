package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastName;

    private String fatherName;

    private String motherName;

    private String birthCertificateNumber;

    private String nationalIdNumber;

    private LocalDate birthDate;

    private String studentNumber;

    private String universityName;

    private String universityType;

    private String admissionYear;

    private String educationalLevel;

    private String approvalType;

    @OneToOne
    private StudentProfile studentProfile;

}
