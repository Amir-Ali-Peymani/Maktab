package org.example.business;


import org.example.entity.*;
import org.example.repository.Impl.StudentLoanRepositoryImpl;
import org.example.repository.StudentLoanRepository;
import org.example.service.Impl.StudentLoanServiceImpl;
import org.example.service.StudentLoanService;

import java.util.List;

public class StudentLoanBusiness {

    private static final StudentLoanRepository studentLoanRepository = new StudentLoanRepositoryImpl();

    private static final StudentLoanService studentLoanService = new StudentLoanServiceImpl(studentLoanRepository);

    public static void createStudentLoanBusiness(long studentId, String moneyAmount , long bankCardNumber, String cvv2, String expiredDate,
                                                 int installments, TuitionLoan tuitionLoan, EducationalLoan educationalLoan, HousingDepositLoan housingDepositLoan){
        Student student = StudentBusiness.getStudentById(studentId);
        if (student != null) {
            StudentLoan studentLoan = new StudentLoan();
            studentLoan.setMoneyAmount(moneyAmount);
            studentLoan.setBankCardNumber(bankCardNumber);
            studentLoan.setCvv2(cvv2);
            studentLoan.setExpiredDate(expiredDate);
            studentLoan.setInstallments(installments);
            studentLoan.setStudent(student);
            studentLoan.setTuitionLoan(tuitionLoan);
            studentLoan.setEducationalLoan(educationalLoan);
            studentLoan.setHousingDepositLoan(housingDepositLoan);
            studentLoanService.saveStudentLoan(studentLoan);
        }
    }

    public static StudentLoan getStudentLoanById(Long id) {
        return studentLoanService.getStudentLoanById(id);
    }

    public static List<StudentLoan> getAllStudentLoan(){
        return studentLoanService.getAllStudentLoan();
    }

    public static void updateStudentLoan(Long id, String moneyAmount, long bankCardNumber, String cvv2, String expiredDate,
                                         int installment, TuitionLoan tuitionLoan, EducationalLoan educationalLoan, HousingDepositLoan housingDepositLoan){
        StudentLoan studentLoan = studentLoanService.getStudentLoanById(id);
        if (studentLoan != null){
            studentLoan.setMoneyAmount(moneyAmount);
            studentLoan.setBankCardNumber(bankCardNumber);
            studentLoan.setCvv2(cvv2);
            studentLoan.setExpiredDate(expiredDate);
            studentLoan.setInstallments(installment);
            studentLoan.setTuitionLoan(tuitionLoan);
            studentLoan.setEducationalLoan(educationalLoan);
            studentLoan.setHousingDepositLoan(housingDepositLoan);
        }
    }

}
