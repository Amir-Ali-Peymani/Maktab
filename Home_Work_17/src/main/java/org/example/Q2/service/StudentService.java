package org.example.Q2.service;

import org.example.Q2.entity.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);

    Student getStudentById(long id);

    List<Student> getAllStudent();

    void updateStudent(Student student);

    void deleteStudent(Student student);
}
