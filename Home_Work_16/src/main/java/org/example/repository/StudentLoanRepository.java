package org.example.repository;

import org.example.entity.Student;
import org.example.entity.StudentLoan;

import java.util.List;

public interface StudentLoanRepository {

    void saveStudentLoan(StudentLoan studentLoan);

    StudentLoan getStudentLoanById(Long id);

    List<StudentLoan> getAllStudentLoan();

    void updateStudentLoan(StudentLoan studentLoan);

    void deleteStudentLoan(StudentLoan studentLoan);

}
