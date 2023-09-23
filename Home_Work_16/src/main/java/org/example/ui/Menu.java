package org.example.ui;

import org.example.base.BaseRepository;
import org.example.business.*;
import org.example.entity.EducationalLoan;
import org.example.entity.HousingDepositLoan;
import org.example.entity.StudentProfile;
import org.example.entity.TuitionLoan;
import org.example.util.Constant;

import java.time.LocalDate;
import java.util.List;


public class Menu extends BaseRepository {
    public static void main(String[] args) {
//        approvalType();
//        System.out.println(approvalType());
//        menu();
//       signUp();
//        loansMenu("Bachelor continues");
    }

    public static void menu(){
        boolean loop = true;
        while (loop){
            Printer.printMenu(Constant.MAIN_MENU);
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            switch (choice){
                case 1 -> signUp();
                case 2 -> signIn();
                case 3 -> loop = false;
            }
        }
    }

    public static void signUp() {
        String userName;
        String password;
        String email;
        String name;
        String lastName;
        String fatherName;
        String motherName;
        String birthCertificateNumber;
        String nationalIdNumber;
        LocalDate birthDate;
        String studentNumber;
        String universityName;
        String universityType;
        String administrative;
        String educationalLevel;
        String approvalType;
        String cities;
        String sex;
        Boolean isMarried;
        userName = inputUtility.getValidCodeToCheck(Constant.USER_NAME_NOTICE, Constant.USER_NAME);
        password = inputUtility.getValiddPassword(Constant.PASSWORD_NOTICE, Constant.PASSWORD);
        email = inputUtility.getValidEmail(Constant.EMAIL_NOTICE, Constant.EMAIL);
        name = inputUtility.getValidName(Constant.NAME_NOTICE, Constant.NAME);
        lastName = inputUtility.getValidName(Constant.NAME_NOTICE, Constant.LAST_NAME);
        fatherName = inputUtility.getValidName(Constant.NAME_NOTICE, Constant.FATHER_NAME);
        motherName = inputUtility.getValidName(Constant.NAME_NOTICE, Constant.MOTHER_NAME);
        birthCertificateNumber = inputUtility.getValidCodeToCheck(Constant.BIRTH_CERTIFICATE_NOTICE, Constant.
                BIRTH_CERTIFICATE_NUMBER);
        nationalIdNumber = inputUtility.getValidCodeToCheck(Constant.NATIONAL_CODE_NOTICE, Constant.NATIONAL_ID_NUMBER);
        birthDate = inputUtility.getValidBirthDate(Constant.BIRTH_DATE_VALID_FORM, Constant.BIRTH_DATE_NOTICE, Constant.
                BIRTH_DATE_WARNING, Constant.BIRTH_DATE_INVALID_INFO);
        studentNumber = inputUtility.getValidCodeToCheck(Constant.STUDENT_ID_NUMBER_NOTICE, Constant.STUDENT_ID_NUMBER);
        universityName = inputUtility.getValidName(Constant.UNIVERSITY_NAME_NOTICE, Constant.UNIVERSITY_NAME);
        universityType = inputUtility.getValidName(Constant.UNIVERSITY_TYPE_NOTICE, Constant.UNIVERSITY_TYPE_NAME);
        administrative = inputUtility.isValidAdministrative(Constant.ADMINISTRATIVE_NOTICE, Constant.ADMINISTRATIVE_NAME);
        educationalLevel = educationalMenu();
        approvalType = approvalType();
        cities = cities();
        sex = getSexType();
        isMarried = getIsMarried();
        StudentBusiness.createStudentBusiness(name, lastName, fatherName, motherName, birthCertificateNumber,
                nationalIdNumber, birthDate, studentNumber, universityName, universityType, administrative,
                educationalLevel, approvalType, cities, sex, isMarried
                StudentProfileBusiness.createStudentProfileBusiness(userName, password, email));

    }

    public static String educationalMenu(){
        String educationalLevel;
        while (true){
            Printer.printMenu(Constant.EDUCATIONAL_MENU);
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            if (choice >= 0 && choice <= Constant.EDUCATIONAL_MENU.length){
                educationalLevel = Constant.EDUCATIONAL_MENU[choice - 1];
                break;
            } else{
                System.out.println(Constant.INVALID_CHOICE);
            }
        }
        return educationalLevel;
    }

    public static String approvalType(){
        String approvalType;
        while (true){
            Printer.printMenu(Constant.APPROVAL_TYPE);
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            if (choice >= 0 && choice <= Constant.APPROVAL_TYPE.length){
                approvalType = Constant.APPROVAL_TYPE[choice -1];
                break;
            } else {
                System.out.println(Constant.INVALID_CHOICE);
            }
        }
        return approvalType;
    }

    public static String cities(){
        String cities;
        while (true){
            Printer.printMenu(Constant.CITIES_NAME);
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            if ( choice >= 0 && choice <= Constant.CITIES_NAME.length){
                cities = Constant.CITIES_NAME[choice -1 ];
                break;
            } else {
                System.out.println(Constant.INVALID_CHOICE);
            }
        }
        return cities;
    }

    public static Boolean getIsMarried(){
        boolean isMarried;
        while (true) {
            Printer.printMenu(Constant.IS_MARRIED);
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            if (choice >= 0 && choice <= Constant.IS_MARRIED.length){
                if (choice == 1){
                    isMarried = true;
                }
                isMarried = false;
                break;
            } else {
                System.out.println(Constant.INVALID_CHOICE);
            }
        }
        return isMarried;
    }
    public static String getSexType(){
        String sexType;
        while (true){
            Printer.printMenu(Constant.SEX_TYPE);
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            if ( choice >= 0 && choice <= Constant.SEX_TYPE.length){
                sexType = Constant.SEX_TYPE[choice -1];
                break;
            } else {
                System.out.println(Constant.INVALID_CHOICE);
            }
        }
        return  null;
    }

    public static void signIn(){
        String userName;
        String password;
        System.out.print(Constant.USER_NAME);
        userName = scanner.next();
        System.out.print(Constant.PASSWORD);
        password = scanner.next();
        List<StudentProfile> studentProfile = StudentProfileBusiness.getAllStudentProfiles();
        for (StudentProfile profile : studentProfile){
            if (profile.getUserName().equals(userName) && profile.getPassword().equals(password)){
                loansMenu("Bachelor");
            }
            else {
                System.out.println(Constant.FAIL);
            }
        }
    }

    public static void loansMenu(String educationalLevel){
        if (isDbEmpty()){
            EducationalLoanBusiness.inputingEducationalLoan();
            HousingDepositLoanBusiness.inputingHousingDepositLoan();
            TuitionLoanBusiness.inputingTuitionLoan();
        }
        boolean loop = true;
        while (loop){
            Printer.printMenu(Constant.LOANS_MENU);
            int num = 0;
            int numberChoice = 0;
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            switch (choice) {
                case 1 ->  tuitionLoan(num, numberChoice, educationalLevel);
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

    public static void tuitionLoan(int num, int numberChoice, String educationalLevel){
        System.out.println(Constant.MENU_LINE);
        List<TuitionLoan> loans = TuitionLoanBusiness.getAllTuitionLoan();
        for (int i = 0; i < TuitionLoanBusiness.getAllTuitionLoan().size() ; i++) {
            TuitionLoan loan = TuitionLoanBusiness.getAllTuitionLoan().get(i);
            System.out.print( i+1 + Constant.DOT + loan.getPaymentMethod() + Constant.DOUBLE_DOT + loan.getPrice() +
                    Constant.DOUBLE_DOT + loan.getSection());
            System.out.println();
        }
        System.out.println(Constant.MENU_LINE);
        numberChoice = inputUtility.giveIntegerInput(Constant.CHOICE);
        switch (numberChoice) {
            case 1 -> {
                if (inputUtility.compareStringsIgnoreSpaces(loans.get(1).getSection(), educationalLevel)){
                    System.out.println("you have successfully");
                }
            }
            case 2 -> {

            }
        }

    }


    public static Boolean isDbEmpty(){
        return TuitionLoanBusiness.getAllTuitionLoan().isEmpty();
    }


}


