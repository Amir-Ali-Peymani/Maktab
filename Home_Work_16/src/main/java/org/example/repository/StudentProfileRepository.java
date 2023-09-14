package org.example.repository;

import org.example.entity.StudentProfile;

import java.util.List;

public interface StudentProfileRepository {

    void saveStudent(StudentProfile studentProfile);

    StudentProfile getStudentById(Long id);

    List<StudentProfile> getAllStudents();

    void updateStudent(StudentProfile studentProfile);

    void deleteStudent(StudentProfile studentProfile);

}
