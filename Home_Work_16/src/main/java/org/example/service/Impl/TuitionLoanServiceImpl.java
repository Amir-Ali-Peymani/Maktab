package org.example.service.Impl;

import org.example.entity.TuitionLoan;
import org.example.repository.TuitionLoanRepository;
import org.example.service.TuitionLoanService;

import java.util.List;

public class TuitionLoanServiceImpl implements TuitionLoanService {

    private final TuitionLoanRepository tuitionLoanRepository;

    public TuitionLoanServiceImpl(TuitionLoanRepository tuitionLoanRepository){
        this.tuitionLoanRepository = tuitionLoanRepository;
    }

    @Override
    public void saveTuitionLoan(TuitionLoan tuitionLoan) {
        tuitionLoanRepository.saveTuitionLoan(tuitionLoan);
    }

    @Override
    public TuitionLoan getTuitionLoanById(Long id) {
        return tuitionLoanRepository.getTuitionLoanById(id);
    }

    @Override
    public List<TuitionLoan> getAllTuitionLoan() {
        return tuitionLoanRepository.getAllTuitionLoan();
    }

    @Override
    public void updateTuitionLoan(TuitionLoan tuitionLoan) {
        tuitionLoanRepository.updateTuitionLoan(tuitionLoan);
    }

    @Override
    public void deleteTuitionLoan(TuitionLoan tuitionLoan) {
        tuitionLoanRepository.deleteTuitionLoan(tuitionLoan);
    }

}
