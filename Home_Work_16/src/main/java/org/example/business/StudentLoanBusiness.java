package org.example.business;


import org.example.entity.Student;
import org.example.entity.StudentLoan;
import org.example.repository.Impl.StudentLoanRepositoryImpl;
import org.example.repository.StudentLoanRepository;
import org.example.service.Impl.StudentLoanServiceImpl;
import org.example.service.StudentLoanService;

import java.time.LocalDate;
import java.util.List;

public class StudentLoanBusiness {

    private static final StudentLoanRepository studentLoanRepository = new StudentLoanRepositoryImpl();

    private static final StudentLoanService studentLoanService = new StudentLoanServiceImpl(studentLoanRepository);

    public static void createStudentLoanBusiness(long studentId, long moneyAmount , long bankCardNumber, String cvv2, LocalDate expiredDate,
                                                 int installments){
        Student student = StudentBusiness.getStudentById(studentId);
        if (student != null) {
            StudentLoan studentLoan = new StudentLoan();
            studentLoan.setMoneyAmount(moneyAmount);
            studentLoan.setBankCardNumber(bankCardNumber);
            studentLoan.setCvv2(cvv2);
            studentLoan.setExpiredDate(expiredDate);
            studentLoan.setInstallments(installments);
            studentLoan.setStudent(student);
            studentLoanService.saveStudentLoan(studentLoan);
        }

    }

    public static StudentLoan getStudentLoanById(Long id) {
        return studentLoanService.getStudentLoanById(id);
    }

    public static List<StudentLoan> getAllStudentLoan(){
        return studentLoanService.getAllStudentLoan();
    }

    public static void updateStudentLoan(Long id, long moneyAmount, long bankCardNumber, String cvv2, LocalDate expiredDate,
                                         int installment){
        StudentLoan studentLoan = studentLoanService.getStudentLoanById(id);
        if (studentLoan != null){
            studentLoan.setMoneyAmount(moneyAmount);
            studentLoan.setBankCardNumber(bankCardNumber);
            studentLoan.setCvv2(cvv2);
            studentLoan.setExpiredDate(expiredDate);
            studentLoan.setInstallments(installment);
        }
    }

}
