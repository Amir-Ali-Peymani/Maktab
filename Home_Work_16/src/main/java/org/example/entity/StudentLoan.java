package org.example.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


}
