package org.example.business;

import org.example.entity.Student;
import org.example.entity.StudentProfile;
import org.example.repository.Impl.StudentRepositoyImpl;
import org.example.repository.StudentRepository;
import org.example.service.Impl.StudentServiceImpl;
import org.example.service.StudentService;

import java.util.List;

public class StudentBusiness {

    private static final StudentRepository studentRepository = new StudentRepositoyImpl();

    private static final StudentService studentService = new StudentServiceImpl(studentRepository);

    public static void createStudentBusiness(String name, String lastName, double gpa, StudentProfile studentProfile){
        Student student = new Student();
        student.setName(name);
        student.setLastName(lastName);
        student.setGpa(gpa);
        student.setStudentProfile(studentProfile);
        studentService.saveStudent(student);
    }

    public static Student getStudentById(Long id) {
        return studentService.getStudentById(id);
    }

    public static List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    public static void updateStudent(Long id, String name, String lastName, double gpa){
        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setLastName(lastName);
            student.setGpa(gpa);
        }
    }

    public static void deleteStudent(Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            studentService.deleteStudent(student);
        }

    }
}
