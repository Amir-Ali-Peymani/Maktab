package org.example.business;


import org.example.entity.EducationalLoan;
import org.example.repository.EducationalLoanRepository;
import org.example.repository.Impl.EducationalLoanRepositoryImpl;
import org.example.service.EducationalLoanService;
import org.example.service.Impl.EducationalLoanServiceImpl;
import org.example.util.Constant;

import java.util.List;

public class EducationalLoanBusiness {

    private static final EducationalLoanRepository educationalLoanRepository = new EducationalLoanRepositoryImpl();

    private static final EducationalLoanService educationalLoanService = new EducationalLoanServiceImpl(educationalLoanRepository);


    public static void inputingEducationalLoan(){
        EducationalLoan educationalLoan1 = new EducationalLoan();
        EducationalLoan educationalLoan2 = new EducationalLoan();
        EducationalLoan educationalLoan3 = new EducationalLoan();
        educationalLoan1.setPaymentMethod(Constant.PAYMENT_TYPE_METHOD_NAME);
        educationalLoan1.setPrice(Constant.PRICE_ONE);
        educationalLoan1.setSection(Constant.SECTION_ONE);
        educationalLoanService.saveEducationalLoan(educationalLoan1);
        educationalLoan2.setPaymentMethod(Constant.PAYMENT_TYPE_METHOD_NAME);
        educationalLoan2.setPrice(Constant.PRICE_TWO);
        educationalLoan2.setSection(Constant.SECTION_TWO);
        educationalLoanService.saveEducationalLoan(educationalLoan2);
        educationalLoan3.setPaymentMethod(Constant.PAYMENT_TYPE_METHOD_NAME);
        educationalLoan3.setPrice(Constant.PRICE_THREE);
        educationalLoan3.setSection(Constant.SECTION_THREE);
        educationalLoanService.saveEducationalLoan(educationalLoan3);
    }


    public static EducationalLoan getEducationalLoanById(Long id) {
        return educationalLoanService.getEducationalById(id);
    }


    public static List<EducationalLoan> getAllEducationalLoan() {
        return educationalLoanService.getAllEducationalLoans();
    }

    public static void updateEducationalLoan(Long id, String paymentMethod, String price, String section){
        EducationalLoan educationalLoan = educationalLoanService.getEducationalById(id);
        if (educationalLoan != null){
            educationalLoan.setPaymentMethod(paymentMethod);
            educationalLoan.setPrice(price);
            educationalLoan.setSection(section);
        }
    }

    public static void deleteEducationalLoan(Long id){
        EducationalLoan educationalLoan = educationalLoanService.getEducationalById(id);
        if (educationalLoan != null){
            educationalLoanService.deleteEducationalLoan(educationalLoan);
        }
    }


}