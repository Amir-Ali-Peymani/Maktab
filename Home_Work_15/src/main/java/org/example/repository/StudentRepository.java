package org.example.repository;

import org.example.entity.Student;


import java.util.List;

public interface StudentRepository {

    void saveStudent(Student student);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    void updateStudent(Student student);

    void deleteStudent(Student student);

}
