package org.example.Q2.repository;

import org.example.Q2.entity.Course;
import org.example.Q2.entity.Student;

import java.util.List;

public interface StudentRepository {

    void saveStudent(Student student);

    Student getStudentById(long id);

    List<Student> getAllStudent();

    void updateStudent(Student student);

    void deleteStudent(Student student);

}
