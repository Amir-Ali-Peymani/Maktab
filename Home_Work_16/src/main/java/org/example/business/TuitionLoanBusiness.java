package org.example.business;

import org.example.entity.TuitionLoan;
import org.example.repository.Impl.TuitionLoanRepositoryImpl;
import org.example.repository.TuitionLoanRepository;
import org.example.service.Impl.TuitionLoanServiceImpl;
import org.example.service.TuitionLoanService;
import org.example.util.Constant;

import java.util.List;

public class TuitionLoanBusiness {

    private static final TuitionLoanRepository tuitionLoanRepository = new TuitionLoanRepositoryImpl();

    private static final TuitionLoanService tuitionLoanService = new TuitionLoanServiceImpl(tuitionLoanRepository);

    public static void inputingTuitionLoan(){
        TuitionLoan tuitionLoan1 = new TuitionLoan();
        TuitionLoan tuitionLoan2 = new TuitionLoan();
        TuitionLoan tuitionLoan3 = new TuitionLoan();
        tuitionLoan1.setPaymentMethod(Constant.PAYMENT_TYPE_METHOD_NAME);
        tuitionLoan1.setPrice(Constant.PRICE_TUITION_ONE);
        tuitionLoan1.setSection(Constant.SECTION_ONE);
        tuitionLoanService.saveTuitionLoan(tuitionLoan1);
        tuitionLoan2.setPaymentMethod(Constant.PAYMENT_TYPE_METHOD_NAME);
        tuitionLoan2.setPrice(Constant.PRICE_TUITION_TWO);
        tuitionLoan2.setSection(Constant.SECTION_TWO);
        tuitionLoanService.saveTuitionLoan(tuitionLoan2);
        tuitionLoan3.setPaymentMethod(Constant.PAYMENT_TYPE_METHOD_NAME);
        tuitionLoan3.setPrice(Constant.PRICE_TUITION_THREE);
        tuitionLoan3.setSection(Constant.SECTION_THREE);
        tuitionLoanService.saveTuitionLoan(tuitionLoan3);
    }


    public static TuitionLoan getTuitionLoan(Long id){
        return tuitionLoanService.getTuitionLoanById(id);
    }

    public static List<TuitionLoan> getAllTuitionLoan(){
        return tuitionLoanService.getAllTuitionLoan();
    }

    public static void updateTuitionLoan(Long id, String paymentMethod, String price, String section){
        TuitionLoan tuitionLoan = tuitionLoanService.getTuitionLoanById(id);
        if (tuitionLoan != null){
            tuitionLoan.setPaymentMethod(paymentMethod);
            tuitionLoan.setPrice(price);
            tuitionLoan.setSection(section);
        }
    }

    public static void deleteTuitionLoan(Long id){
        TuitionLoan tuitionLoan = tuitionLoanService.getTuitionLoanById(id);
        if (tuitionLoan != null){
            tuitionLoanService.deleteTuitionLoan(tuitionLoan);
        }
    }

}
