package org.example.ui;

import org.example.base.BaseRepository;
import org.example.business.StudentBusiness;
import org.example.business.StudentProfileBusiness;
import org.example.entity.StudentProfile;
import org.example.util.Constant;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.time.LocalDate;
import java.util.List;


public class Menu extends BaseRepository {
    public static void main(String[] args) {
        loansMenu();
//        menu();
//        signUp();
    }

    public static void menu(){
        boolean loop = true;
        while (loop){
            Printer.printMenu(Constant.MAIN_MENU);
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            if (choice == 1){
                signUp();
            }
            if (choice == 2){
                signIn();
            }
            if (choice == 3){
                loop = false;
            }
        }
    }

    public static void signUp(){
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
        userName = inputUtility.getValidCodeToCheck(Constant.USER_NAME_NOTICE, Constant.USER_NAME);
        password = inputUtility.getValiddPassword(Constant.PASSWORD_NOTICE, Constant.PASSWORD);
        email = inputUtility.getValidEmail(Constant.EMAIL_NOTICE, Constant.EMAIL);
        name = inputUtility.getValidName(Constant.NAME_NOTICE, Constant.NAME);
        lastName = inputUtility.getValidName(Constant.NAME_NOTICE, Constant.LAST_NAME);
        fatherName = inputUtility.getValidName(Constant.NAME_NOTICE, Constant.FATHER_NAME);
        motherName = inputUtility.getValidName(Constant.NAME_NOTICE, Constant.MOTHER_NAME);
        birthCertificateNumber = inputUtility.getValidCodeToCheck(Constant.BIRTH_CERTIFICATE_NOTICE, Constant.BIRTH_CERTIFICATE_NUMBER);
        nationalIdNumber = inputUtility.getValidCodeToCheck(Constant.NATIONAL_CODE_NOTICE, Constant.NATIONAL_ID_NUMBER);
        birthDate = inputUtility.getValidBirthDate(Constant.BIRTH_DATE_VALID_FORM, Constant.BIRTH_DATE_NOTICE, Constant.BIRTH_DATE_WARNING, Constant.BIRTH_DATE_INVALID_INFO);
        studentNumber = inputUtility.getValidCodeToCheck(Constant.STUDENT_ID_NUMBER_NOTICE, Constant.STUDENT_ID_NUMBER);
        universityName = inputUtility.getValidName(Constant.UNIVERSITY_NAME_NOTICE, Constant.UNIVERSITY_NAME);
        universityType = inputUtility.getValidName(Constant.UNIVERSITY_TYPE_NOTICE, Constant.UNIVERSITY_TYPE_NAME);
        administrative = inputUtility.isValidAdministrative(Constant.ADMINISTRATIVE_NOTICE, Constant.ADMINISTRATIVE_NAME);
        educationalLevel = inputUtility.getValidName(Constant.EDUCATIONAL_LEVEL_NOTICE, Constant.EDUCATIONAL_LEVEL_NAME);
        approvalType = inputUtility.getValidName(Constant.APPROVAL_TYPE_NOTICE, Constant.APPROVAL_TYPE_NAME);
        StudentBusiness.createStudentBusiness(name, lastName, fatherName, motherName, birthCertificateNumber,
                nationalIdNumber, birthDate, studentNumber, universityName, universityType, administrative,
                educationalLevel, approvalType, StudentProfileBusiness.createStudentProfileBusiness(userName, password,
                        email));

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
                System.out.println("Sign in Successfully! ");

            }
            else {
                System.out.println("Sign in Failure");
            }
        }
    }

    public static void loansMenu(){
        boolean loop = true;
        while (loop){
            Printer.printMenu(Constant.LOANS_MENU);
            int choice = inputUtility.giveIntegerInput(Constant.CHOICE);
            switch(choice){
                case 1:
                    System.out.println("tuition loan");
                case 2:
                    System.out.println("education loan");
                case 3:
                    System.out.println("housing deposit loan");
                case 4:
                    loop = false;
            }
        }
    }
}


