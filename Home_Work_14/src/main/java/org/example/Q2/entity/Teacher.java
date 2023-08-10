package org.example.Q2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
public class Teacher extends Person {

    private Long id;

    private String name;

    private String lastName;

    private int inCome;

    @ManyToOne
    Person person;
}
