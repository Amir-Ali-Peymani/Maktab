package org.example.service.Impl;

import org.example.entity.EducationalLoan;
import org.example.repository.EducationalLoanRepository;
import org.example.service.EducationalLoanService;

import java.util.List;

public class EducationalLoanServiceImpl implements EducationalLoanService {

    private final EducationalLoanRepository educationalLoanRepository;

    public EducationalLoanServiceImpl(EducationalLoanRepository educationalLoanRepository){
        this.educationalLoanRepository = educationalLoanRepository;
    }

    @Override
    public void saveEducationalLoan(EducationalLoan educationalLoan) {
        educationalLoanRepository.saveEducationalLoan(educationalLoan);
    }

    @Override
    public EducationalLoan getEducationalById(Long id) {
        return educationalLoanRepository.getEducationalLoanById(id);
    }

    @Override
    public List<EducationalLoan> getAllEducationalLoans() {
        return educationalLoanRepository.getAllEducationalLoan();
    }

    @Override
    public void updateEducaionalLoan(EducationalLoan educationalLoan) {
        educationalLoanRepository.updateEducationalLoan(educationalLoan);
    }

    @Override
    public void deleteEducationalLoan(EducationalLoan educationalLoan) {
        educationalLoanRepository.deleteEducationalLoan(educationalLoan);
    }
}
