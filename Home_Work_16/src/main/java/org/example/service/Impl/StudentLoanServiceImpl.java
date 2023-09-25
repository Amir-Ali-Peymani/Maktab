package org.example.service.Impl;


import org.example.entity.StudentLoan;
import org.example.repository.StudentLoanRepository;
import org.example.service.StudentLoanService;

import java.util.List;

public class StudentLoanServiceImpl implements StudentLoanService {

    private final StudentLoanRepository studentLoanRepository;

    public StudentLoanServiceImpl(StudentLoanRepository studentLoanRepository) {
        this.studentLoanRepository = studentLoanRepository;
    }

    @Override
    public void saveStudentLoan(StudentLoan studentLoan) {
        studentLoanRepository.saveStudentLoan(studentLoan);
    }

    @Override
    public StudentLoan getStudentLoanById(Long id) {
        return studentLoanRepository.getStudentLoanById(id);
    }

    @Override
    public List<StudentLoan> getAllStudentLoan() {
        return studentLoanRepository.getAllStudentLoan();
    }

    @Override
    public void updateStudentLoan(StudentLoan studentLoan) {
        studentLoanRepository.updateStudentLoan(studentLoan);
    }

    @Override
    public void deleteStudentLoan(StudentLoan studentLoan) {
        studentLoanRepository.deleteStudentLoan(studentLoan);
    }

}

