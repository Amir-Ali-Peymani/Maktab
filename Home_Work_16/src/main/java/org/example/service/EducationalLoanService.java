package org.example.service;

import org.example.entity.EducationalLoan;

import java.util.List;

public interface EducationalLoanService {

    void saveEducationalLoan(EducationalLoan educationalLoan);

    EducationalLoan getEducationalById(Long id);

    List<EducationalLoan> getAllEducationalLoans();

    void updateEducaionalLoan(EducationalLoan educationalLoan);

    void deleteEducationalLoan(EducationalLoan educationalLoan);

}
