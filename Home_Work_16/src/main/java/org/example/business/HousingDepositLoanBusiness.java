package org.example.business;

import org.example.entity.HousingDepositLoan;
import org.example.repository.HousingDepositLoanRepository;
import org.example.repository.Impl.HousingDepositLoanRespositoryImpl;
import org.example.service.HousingDepositLoanService;
import org.example.service.Impl.HousingDepositLoanServiceImpl;
import org.example.util.Constant;

import java.util.List;

public class HousingDepositLoanBusiness {

    private static final HousingDepositLoanRepository housingDepositLoanrepository = new HousingDepositLoanRespositoryImpl();

    private static final HousingDepositLoanService housingDepositLoanService = new HousingDepositLoanServiceImpl(housingDepositLoanrepository);


    public static void inputingHousingDepositLoan(){
        HousingDepositLoan housingDepositLoan1 = new HousingDepositLoan();
        HousingDepositLoan housingDepositLoan2 = new HousingDepositLoan();
        HousingDepositLoan housingDepositLoan3 = new HousingDepositLoan();
        housingDepositLoan1.setPaymentMethod(Constant.PAYMENT_TYPE_METHOD_HOUSING_DEPOSIT_LOAN);
        housingDepositLoan1.setPrice(Constant.PRICE_HOUSING_DEPOSIT_ONE);
        housingDepositLoan1.setCity(Constant.HOUSING_DEPOSIT_ONE);
        housingDepositLoanService.saveHousingDepositLoan(housingDepositLoan1);
        housingDepositLoan2.setPaymentMethod(Constant.PAYMENT_TYPE_METHOD_HOUSING_DEPOSIT_LOAN);
        housingDepositLoan2.setPrice(Constant.PRICE_HOUSING_DEPOSIT_TWO);
        housingDepositLoan2.setCity(Constant.HOUSING_DEPOSIT_TWO);
        housingDepositLoanService.saveHousingDepositLoan(housingDepositLoan2);
        housingDepositLoan3.setPaymentMethod(Constant.PAYMENT_TYPE_METHOD_HOUSING_DEPOSIT_LOAN);
        housingDepositLoan3.setPrice(Constant.PRICE_HOUSING_DEPOSIT_THREE);
        housingDepositLoan3.setCity(Constant.HOUSING_DEPOSIT_THREE);
        housingDepositLoanService.saveHousingDepositLoan(housingDepositLoan3);

    }

    public static HousingDepositLoan getHousingDepositLoanById(Long id) {
        return housingDepositLoanService.getHousingDepositLoanById(id);
    }

    public static List<HousingDepositLoan> getAllHousingDepositesLoan(){
        return housingDepositLoanService.getAllHousingDeposites();
    }

    public static void updateHousingDepositLoan(Long id, String paymentMethod, String price, String city){
        HousingDepositLoan housingDepositLoan = housingDepositLoanService.getHousingDepositLoanById(id);
        if (housingDepositLoan != null ){
            housingDepositLoan.setPaymentMethod(paymentMethod);
            housingDepositLoan.setPrice(price);
            housingDepositLoan.setCity(city);
        }
    }

    public static void deleteHousingDepositLoan(Long id){
        HousingDepositLoan housingDepositLoan = housingDepositLoanService.getHousingDepositLoanById(id);
        if (housingDepositLoan != null ){
            housingDepositLoanService.deleteHousingDeposites(housingDepositLoan);
        }
    }

}
