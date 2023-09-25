package org.example.ui;

import org.example.base.BaseRepository;
import org.example.business.EducationalLoanBusiness;
import org.example.business.HousingDepositLoanBusiness;
import org.example.business.StudentLoanBusiness;
import org.example.business.TuitionLoanBusiness;
import org.example.entity.EducationalLoan;
import org.example.entity.HousingDepositLoan;
import org.example.entity.Student;
import org.example.entity.TuitionLoan;
import org.example.util.Constant;

import java.time.LocalDate;


public class LoansMenu extends BaseRepository {

    public static void loansMenu(long id) {
        if (isDbEmpty()) {
            EducationalLoanBusiness.inputingEducationalLoan();
            HousingDepositLoanBusiness.inputingHousingDepositLoan();
            TuitionLoanBusiness.inputingTuitionLoan();
        }
        boolean loop = true;
        while (loop) {
            Printer.printMenu(Constant.LOANS_MENU);
            int num = 0;
            int numberChoice = 0;
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            switch (choice) {
                case 1 -> tuitionLoan(numberChoice, id);
                case 2 -> {
                    System.out.println(Constant.MENU_LINE);
                    for (EducationalLoan loan : EducationalLoanBusiness.getAllEducationalLoan()) {
                        System.out.print(num += 1);
                        System.out.print(Constant.DOT + loan.getPaymentMethod() + Constant.DOUBLE_DOT + loan.getPrice() +
                                Constant.DOUBLE_DOT + loan.getSection());
                        System.out.println();
                    }
                    System.out.println(Constant.MENU_LINE);
//                    numberChoice = inputUtility.giveIntegerInput(Constant.CHOICE);
                }
                case 3 -> {
                    System.out.println(Constant.MENU_LINE);
                    for (HousingDepositLoan loan : HousingDepositLoanBusiness.getAllHousingDepositesLoan()) {
                        System.out.print(num += 1);
                        System.out.print(Constant.DOT + loan.getPaymentMethod() + Constant.DOUBLE_DOT + loan.getPrice() +
                                Constant.DOUBLE_DOT + loan.getCity());
                        System.out.println();
                    }
                    System.out.println(Constant.MENU_LINE);
//                    numberChoice = inputUtility.giveIntegerInput(Constant.CHOICE);
                }
                case 4 -> loop = false;
            }
        }

    }
    public static void tuitionLoan(int numberChoice, long id){
        System.out.println(Constant.MENU_LINE);
        for (TuitionLoan loan : TuitionLoanBusiness.getAllTuitionLoan()){
            System.out.println(loan.getId() + Constant.DOT + loan.getPaymentMethod() + Constant.DOUBLE_DOT + loan.getPrice()
                    + Constant.DOUBLE_DOT + loan.getSection());
        }
        System.out.println(Constant.MENU_LINE);
        numberChoice = inputUtility.giveIntegerInput(Constant.CHOICE);

    }

    public static Boolean isDbEmpty(){
        return TuitionLoanBusiness.getAllTuitionLoan().isEmpty();
    }

    public static void gettingLoanInformation(){

        long moneyAmount;

        long bankCardNumber;

        String cvv2;

        LocalDate localDate;

        int installments;





    }

}