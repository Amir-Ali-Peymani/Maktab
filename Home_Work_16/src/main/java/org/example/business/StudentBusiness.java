package org.example.business;

import org.example.entity.Student;
import org.example.entity.StudentProfile;
import org.example.repository.Impl.StudentRepositoryImpl;
import org.example.repository.StudentRepository;
import org.example.service.Impl.StudentServiceImpl;
import org.example.service.StudentService;

import java.time.LocalDate;
import java.util.List;

public class StudentBusiness {

    private static final StudentRepository studentRepository = new StudentRepositoryImpl();

    private static final StudentService studentService = new StudentServiceImpl(studentRepository);

    public static void createStudentBusiness(String name, String lastName, String fatherName, String motherName,
                                             String BirthCertificateNumber, String NationalIdNumber, LocalDate birthDate,
                                             String studentId, String universityName, String universityType,
                                             String admissionYear, String educationalLevel, String approvalType,
                                             StudentProfile studentProfile){
        Student student = new Student();
        student.setName(name);
        student.setLastName(lastName);
        student.setFatherName(fatherName);
        student.setMotherName(motherName);
        student.setBirthCertificateNumber(BirthCertificateNumber);
        student.setNationalIdNumber(NationalIdNumber);
        student.setBirthDate(birthDate);
        student.setStudentNumber(studentId);
        student.setUniversityName(universityName);
        student.setUniversityType(universityType);
        student.setAdmissionYear(admissionYear);
        student.setEducationalLevel(educationalLevel);
        student.setApprovalType(approvalType);
        student.setStudentProfile(studentProfile);
        studentService.saveStudent(student);
    }

    public static Student getStudentById(Long id) {
        return studentService.getStudentById(id);
    }

    public static List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    public static void updateStudent(Long id,String name, String lastName, String fatherName, String motherName,
                                     String BirthCertificateNumber, String NationalIdNumber, LocalDate birthDate,
                                     String studentId, String universityName, String universityType,
                                     String admissionYear, String educationalLevel, String approvalType){
        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setLastName(lastName);
            student.setFatherName(fatherName);
            student.setMotherName(motherName);
            student.setBirthCertificateNumber(BirthCertificateNumber);
            student.setNationalIdNumber(NationalIdNumber);
            student.setBirthDate(birthDate);
            student.setStudentNumber(studentId);
            student.setUniversityName(universityName);
            student.setUniversityType(universityType);
            student.setAdmissionYear(admissionYear);
            student.setEducationalLevel(educationalLevel);
            student.setApprovalType(approvalType);
        }
    }

    public static void deleteStudent(Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            studentService.deleteStudent(student);
        }

    }

}
