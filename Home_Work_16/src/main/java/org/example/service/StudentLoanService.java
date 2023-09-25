package org.example.service;

import org.example.entity.StudentLoan;

import java.util.List;

public interface StudentLoanService {
    void saveStudentLoan(StudentLoan studentLoan);

    StudentLoan getStudentLoanById(Long id);

    List<StudentLoan> getAllStudentLoan();

    void updateStudentLoan(StudentLoan studentLoan);

    void deleteStudentLoan(StudentLoan studentLoan);

}
