package org.example.repository;

import org.example.entity.TuitionLoan;

import java.util.List;

public interface TuitionLoanRepository {

    void saveTuitionLoan(TuitionLoan tuitionLoan);

    TuitionLoan getTuitionLoanById(Long id);

    List<TuitionLoan> getAllTuitionLoan();

    void updateTuitionLoan(TuitionLoan tuitionLoan);

    void deleteTuitionLoan(TuitionLoan tuitionLoan);

}
