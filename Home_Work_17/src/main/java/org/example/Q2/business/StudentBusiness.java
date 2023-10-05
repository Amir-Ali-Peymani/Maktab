package org.example.Q2.business;

import org.example.Q2.entity.Student;
import org.example.Q2.repository.Impl.StudentRepositoryImpl;
import org.example.Q2.repository.StudentRepository;
import org.example.Q2.service.Impl.StudentServiceImpl;
import org.example.Q2.service.StudentService;

import java.util.List;

public class StudentBusiness {

    private static final StudentRepository studentRepository = new StudentRepositoryImpl();

    private static final StudentService studentService = new StudentServiceImpl(studentRepository);

    public static Student createStudent(String studentName){
        Student student = new Student();
        student.setStudentName(studentName);
        studentService.saveStudent(student);
        return student;
    }

    public static Student getStudentById(Long id){
        return studentService.getStudentById(id);
    }

    public static List<Student> getStudentList(){
        return studentService.getAllStudent();
    }

    public static void updateStudent(Long id, String studentName){
        Student student = studentService.getStudentById(id);
        if (student != null)
            student.setStudentName(studentName);
    }

    public static void deleteStudent(Long id){
        Student student = studentService.getStudentById(id);
        if (student != null){
            studentService.deleteStudent(student);
        }
    }

}
