package org.example.ui;

import org.example.base.BaseRepository;
import org.example.business.StudentBusiness;
import org.example.business.StudentProfileBusiness;
import org.example.entity.Student;
import org.example.entity.StudentProfile;
import org.example.util.Constant;

import java.time.LocalDate;
import java.util.List;

public class SignInAndSignUp extends BaseRepository {

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
                educationalLevel, approvalType, cities, sex, isMarried,
                StudentProfileBusiness.createStudentProfileBusiness(userName, password, email));
        for (Student student : StudentBusiness.getAllStudent()){
            if (student.getNationalIdNumber().equals(nationalIdNumber)){
                LoansMenu.loansMenu(student.getId());
            }
        }
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
                System.out.println();
            }
            else {
                System.out.println(Constant.FAIL);
            }
        }
    }

}
