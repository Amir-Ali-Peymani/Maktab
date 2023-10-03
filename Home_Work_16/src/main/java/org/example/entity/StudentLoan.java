package org.example.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String moneyAmount;

    private long bankCardNumber;

    private String cvv2;

    private String expiredDate;

    private int installments;

    @ManyToOne
    @JoinColumn(name = "Tuition_loan_id")
    private TuitionLoan tuitionLoan;

    @ManyToOne
    @JoinColumn(name = "Educational_loan_id")
    private EducationalLoan educationalLoan;

    @ManyToOne
    @JoinColumn(name = "Housing_loan_id")
    private HousingDepositLoan housingDepositLoan;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
