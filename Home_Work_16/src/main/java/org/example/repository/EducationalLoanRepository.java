package org.example.repository;

import org.example.entity.EducationalLoan;

import java.util.List;

public interface EducationalLoanRepository {

    void saveEducationalLoan(EducationalLoan educationalLoan);

    EducationalLoan getEducationalLoanById(Long id);

    List<EducationalLoan> getAllEducationalLoan();

    void updateEducationalLoan(EducationalLoan educationalLoan);

    void deleteEducationalLoan(EducationalLoan educationalLoan);

}
