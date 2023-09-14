package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastName;

    private double gpa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentProfile_id")
    private StudentProfile studentProfile;

    @OneToMany(mappedBy = "student")
    List<UniClass> uniClasses;

}
