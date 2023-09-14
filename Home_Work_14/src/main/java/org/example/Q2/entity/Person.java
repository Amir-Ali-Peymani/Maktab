package org.example.Q2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@ToString
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastName;

    private LocalDate birthDate;

    @OneToMany
    List<Student> students;

    @OneToMany
    List<Teacher> teachers;
}
