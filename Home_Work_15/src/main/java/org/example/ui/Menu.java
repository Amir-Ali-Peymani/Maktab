package org.example.ui;

import org.example.entity.*;
import org.example.business.*;
import org.example.util.Constant;
import org.example.util.Validation;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
//        UniClass uniClass = new UniClass();
//        Course course = new Course();
//        Semester semester = new Semester();
//        Subject subject = new Subject();
//        Teacher teacher = new Teacher();
//
//        subject.setName("mathematic");
//        teacher.setName("ahmadi");
//        semester.setName("3");
//        course.setSubject(subject);
//        course.setTeacher(teacher);
//        course.setSemester(semester);
//
//        uniClass.setScore(3);
//    String userName ="amriali_pe";
//
//    String password = "3223423";
//
//    String email = "aemrar@gmail.com";
//
//    String name = "amriali";
//
//    String lastName = "peymani";
//
//    int salary = 3234234;
//
//    signUpStudent(userName, password, email, name, lastName, salary);
//
//    signUpTeacher(userName, password, email, name, lastName, salary);
//
//    signInStudentProfile(userName, password);
//
//    signInTeacherProfile(userName, password);

//    SubjectBusiness.createSubject("Mathematics");
//    SubjectBusiness.createSubject("English");
//    SubjectBusiness.createSubject("Physics");

//    signUpEmployee("amriali", "1234", "amria@gmail.com", "amirali", "peyamni");

//    SemesterBusiness.createSemester("2");
//    SemesterBusiness.createSemester("3");
//
//    signUpTeacher("amrialie_pey", "234234", "amrialir@gmail.com", "amirali", "peymani"
//    , 234234);
//
//
//
//    CourseBusiness.createCourseBusiness(SemesterBusiness.getSemesterById(5L), SubjectBusiness.getSubject(3L),
//            TeacherBusiness.getTeacherById(6L));
//
//    signUpStudent("amrialie_pey", "234234", "amrialir",
//            "amirali", "peymani", 23);
//
//    UniClassBusiness.createUniClass(SubjectBusiness.getSubject(3L).getName(),
//            34, CourseBusiness.getCourseById(8L), StudentBusiness.getStudentById(9L));

//
//    List<UniClass> scores = StudentBusiness.getStudentById(9L).getUniClasses();
//    for( UniClass uniClass : scores ){
//        System.out.println(uniClass.getScore());
//    }

//        System.out.println(UniClassBusiness.getUniClassById(11L).getScore());
    List<Student> students ;




//    menu();

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu(){
        boolean loop = true;
        while (loop){
            Printer.printMenu(Constant.MENU);
            System.out.print(Constant.CHOICE);
            int choice = scanner.nextInt();
            if (choice == 1){
                teacherMenu();
            }
            if (choice == 2){
                System.out.println("employee");
            }
            if (choice == 3){
                System.out.println("student");
            }
            if (choice == 4){
                loop = false;
            }
        }
    }

    public static void teacherMenu(){
        boolean loop = true;
        while (loop){
            Printer.printMenu(Constant.TEACHER_MENU);
            System.out.println(Constant.TEACHER_MENU_CHOICE);
            int teacherChoice = scanner.nextInt();

            if (teacherChoice == 1){
                System.out.println(Constant.USER_NAME);
                String userName = scanner.next();
                System.out.println(Constant.PASSWORD);
                String password = scanner.next();
                System.out.println(Constant.EMAIL);
                String email = scanner.next();
                Validation.isValidEmail(email);
                System.out.println(Constant.NAME);
                String name = scanner.next();
                System.out.println(Constant.LAST_NAME);
                String lastName = scanner.next();
                System.out.println(Constant.SALARY);
                int salary = scanner.nextInt();
                signUpTeacher(userName, password, email, name, lastName, salary);
            }
            if (teacherChoice == 2){
                System.out.println(Constant.USER_NAME);
                String userName = scanner.next();
                System.out.println(Constant.PASSWORD);
                String password = scanner.next();
                signInTeacherProfile(userName, password);
            }
            if (teacherChoice == 3){
                loop = false;
            }
        }

    }
    public static void signUpStudent(String userName, String password , String email, String name, String lastName,
                                     double gpa){
        StudentProfile studentProfile =
                StudentProfileBusiness.createStudentProfile(userName, password,
                        email);

        StudentBusiness.createStudentBusiness(name, lastName, gpa, studentProfile);
    }

    public static void signInStudentProfile(String userName, String password){
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

    public static void readStudentById(Long id){
        Student student = StudentBusiness.getStudentById(id);
        System.out.println(student.getName());
        System.out.println(student.getLastName());
        System.out.println(student.getGpa());
    }

    public static void readStudentProfileByid(Long id){
        StudentProfile studentProfile = StudentProfileBusiness.getStudentProfileById(id);
        System.out.println(studentProfile.getUserName());
        System.out.println(studentProfile.getEmail());
    }

    public static void updateStudent(Long id, String name, String lastName, double gpa){
        StudentBusiness.updateStudent(id, name, lastName, gpa);
    }

    public static void updateStudentProfie(Long id, String userName, String password, String email){
        StudentProfileBusiness.updateStudentProfile(id, userName, password, email);
    }

    public static void deleteStudent(Long id){
        StudentBusiness.deleteStudent(id);
    }

    public static void deleteStudentProfie(Long id){
        StudentProfileBusiness.deleteStudentProfile(id);
    }


    public static void signUpTeacher(String userName, String password, String email, String name, String lastName, int salary){
        TeacherProfile teacherProfile =
                TeacherProfileBusiness.createTeacherProfile(userName, password, email);

        TeacherBusiness.createTeacher(name, lastName, salary, teacherProfile);
    }

    public static void signInTeacherProfile(String userName, String password){
        List<TeacherProfile> teacherProfiles = TeacherProfileBusiness.getAllTeacherProfiles();

        for (TeacherProfile profile : teacherProfiles){
            if (profile.getUserName().equals(userName) &&
                    profile.getPassword().equals(password)){
                System.out.println("Sign in Successfully! ");
                return;
            }
            else {
                System.out.println("Sign in Failure");
            }
        }
    }

    public static void readTeacherById(Long id){
        Teacher teacher = TeacherBusiness.getTeacherById(id);
        System.out.println(teacher.getName());
        System.out.println(teacher.getLastName());
        System.out.println(teacher.getSalary());
    }

    public static void readTeacherProfileById(Long id){
        TeacherProfile teacherProfile = TeacherProfileBusiness.getTeacherProfileById(id);
        System.out.println(teacherProfile.getUserName());
        System.out.println(teacherProfile.getPassword());
        System.out.println(teacherProfile.getEmail());
    }


    public static void updateTeacher(Long id , String name, String lastName, int salary){
        TeacherBusiness.updateTeacher(id, name, lastName, salary);
    }

    public static void updateTeacherProfile(Long id, String userName, String password, String email){
        TeacherProfileBusiness.updateTeacherProfile(id, userName, password, email);
    }

    public static void deleteTeacher(Long id){
        TeacherBusiness.deleteTeacher(id);
    }

    public static void deleteTeacherProfile(Long id){
        TeacherProfileBusiness.deleteTeacherProfile(id);
    }

    public static void signUpEmployee(String userName, String password, String email, String name, String lastName){
        EmployeeProfile employeeProfile =
                EmployeeProfileBusiness.createEmployeeProfile(userName, password, email);

        EmployeeBusiness.createEmployee(name, lastName, employeeProfile);
    }

    public static void signInEmployeeProfile(String userName, String password){
        List<EmployeeProfile> employeeProfiles = EmployeeProfileBusiness.getAllEmployees();

        for (EmployeeProfile profile : employeeProfiles){
            if (profile.getUserName().equals(userName) && profile.getPassword().equals(password)){
                System.out.println("Sign in Successfully");
            }
            else{
                System.out.println("Sign in Failure");
            }
        }
    }

    public static void readEmployeeById(Long id){
        Employee employee = EmployeeBusiness.getEmployeeById(id);
        System.out.println(employee.getName());
        System.out.println(employee.getLastName());
    }

    public static void readEmployeeProfile(Long id){
        EmployeeProfile employeeProfile = EmployeeProfileBusiness.getEmployeeProfileById(id);
        System.out.println(employeeProfile.getUserName());
        System.out.println(employeeProfile.getPassword());
        System.out.println(employeeProfile.getEmail());
    }

    public static void updateEmployee(Long id, String name, String lastName){
        EmployeeBusiness.updateEmployee(id, name, lastName);
    }

    public static void updateEmployeeProfile(Long id, String userName, String password, String email){
        EmployeeProfileBusiness.updateEmployeeProfile(id, userName, password, email);
    }

    public static void deleteEmployee(Long id){
        EmployeeBusiness.deleteEmployee(id);
    }

    public static void deleteEmployeeProfile(Long id){
        EmployeeProfileBusiness.deleteEmployeeProfile(id);
    }

}
