package org.example.ui;

import org.example.base.BaseRepository;
import org.example.business.EducationalLoanBusiness;
import org.example.business.HousingDepositLoanBusiness;
import org.example.business.StudentLoanBusiness;
import org.example.business.TuitionLoanBusiness;
import org.example.entity.EducationalLoan;
import org.example.entity.HousingDepositLoan;
import org.example.entity.StudentLoan;
import org.example.entity.TuitionLoan;
import org.example.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentNavigableMap;


public class LoansMenu extends BaseRepository {

    public static void loansMenu(long id) {
        if (isDbEmpty()) {
            EducationalLoanBusiness.inputingEducationalLoan();
            HousingDepositLoanBusiness.inputingHousingDepositLoan();
            TuitionLoanBusiness.inputingTuitionLoan();
        }
        boolean loop = true;
        TuitionLoan tuitionLoan = new TuitionLoan();
        EducationalLoan educationalLoan = new EducationalLoan();
        HousingDepositLoan housingDepositLoan = new HousingDepositLoan();
        while (loop) {
            Printer.printMenu(Constant.LOANS_MENU);
            int num = 0;
            long numberChoice = 0;
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            switch (choice) {
                case 1 -> tuitionLoan(numberChoice, id);
                case 2 -> educationalLoan(numberChoice, id);
                case 3 -> housingDepositLoan(numberChoice, id);
                case 4 -> loop = false;
            }
        }

    }

    public static void tuitionLoan(long numberChoice, long id){
        System.out.println(Constant.MENU_LINE);
        for (TuitionLoan loan : TuitionLoanBusiness.getAllTuitionLoan()) {
            System.out.println(loan.getId() + Constant.DOT + loan.getPaymentMethod() + Constant.DOUBLE_DOT + loan.getPrice()
                    + Constant.DOUBLE_DOT + loan.getSection());
        }
        System.out.println(Constant.MENU_LINE);
        numberChoice = inputUtility.giveIntegerInput(Constant.CHOICE);
        TuitionLoan tuitionLoan = TuitionLoanBusiness.getTuitionLoan(numberChoice);
        String money = TuitionLoanBusiness.getTuitionLoan(numberChoice).getPrice();
        gettingLoanInformation(tuitionLoan, null, null, money, id);
    }

    public static void educationalLoan(long numberChoice, long id){
        System.out.println(Constant.MENU_LINE);
        for (EducationalLoan loan : EducationalLoanBusiness.getAllEducationalLoan()){
            System.out.println(loan.getId() + Constant.DOT + loan.getPaymentMethod() + Constant.DOUBLE_DOT + loan.getPrice()
                    + Constant.DOUBLE_DOT + loan.getSection());
        }
        System.out.println(Constant.MENU_LINE);
        numberChoice = inputUtility.giveIntegerInput(Constant.CHOICE);
        EducationalLoan educationalLoan = EducationalLoanBusiness.getEducationalLoanById(numberChoice);
        String money = EducationalLoanBusiness.getEducationalLoanById(numberChoice).getPrice();
        gettingLoanInformation(null, educationalLoan, null, money, id);
    }

    public static void housingDepositLoan(long numberChoice, long id){
        System.out.println(Constant.MENU_LINE);
        for (HousingDepositLoan loan : HousingDepositLoanBusiness.getAllHousingDepositesLoan()){
            System.out.println(loan.getId() + Constant.DOT + loan.getPaymentMethod() + Constant.DOUBLE_DOT + loan.getPrice()
                    + Constant.DOUBLE_DOT + loan.getCity());
        }
        System.out.println(Constant.MENU_LINE);
        numberChoice = inputUtility.giveIntegerInput(Constant.CHOICE);
        HousingDepositLoan housingDepositLoan = HousingDepositLoanBusiness.getHousingDepositLoanById(numberChoice);
        String money = HousingDepositLoanBusiness.getHousingDepositLoanById(numberChoice).getPrice();
        gettingLoanInformation(null, null, housingDepositLoan, money, id);
    }

    public static Boolean isDbEmpty(){
        return TuitionLoanBusiness.getAllTuitionLoan().isEmpty();
    }

    public static void gettingLoanInformation(TuitionLoan tuitionLoan, EducationalLoan educationalLoan
            , HousingDepositLoan housingDepositLoan, String money, long id){

        long idLoan = 0;

        String moneyAmount;

        long bankCardNumber = 12412311231L;

        String cvv2 = "2333";

        String cardExpireDate = "23032";

        int installments;
//
//        System.out.print(Constant.BANK_NUMBER);
//        bankCardNumber = scanner.nextLong();
//        System.out.print(Constant.CVV2);
//        cvv2 = scanner.next();
//        System.out.print(Constant.CARD_EXPIRED_DATE);
//        cardExpireDate = scanner.next();
        moneyAmount = money;
        installments = 2;
        StudentLoanBusiness.createStudentLoanBusiness(id, moneyAmount, bankCardNumber,cvv2, cardExpireDate, installments,
                null,  null, null);
        for (StudentLoan studentLoan : StudentLoanBusiness.getAllStudentLoan()) {
            if (studentLoan.getBankCardNumber() == bankCardNumber){
                idLoan = studentLoan.getId();
            }
        }
        if (tuitionLoan != null){
            StudentLoanBusiness.updateStudentLoan(idLoan, moneyAmount, bankCardNumber, cvv2, cardExpireDate, installments, tuitionLoan, null, null );
        }
        if (educationalLoan != null){
            StudentLoanBusiness.updateStudentLoan(idLoan, moneyAmount, bankCardNumber, cvv2, cardExpireDate, installments, null, educationalLoan, null);
        }
        if (housingDepositLoan != null){
            StudentLoanBusiness.updateStudentLoan(idLoan, moneyAmount, bankCardNumber, cvv2, cardExpireDate, installments, null, null, housingDepositLoan);
        }
    }

}

