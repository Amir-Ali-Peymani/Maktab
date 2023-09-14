package org.example.service;

import org.example.entity.StudentProfile;

import java.util.List;

public interface StudentProfileService {

    void saveStudentProfile(StudentProfile studentProfile);

    StudentProfile getStudentProfileById(Long id);

    List<StudentProfile> getAllStudentsProfile();

    void updateStudentProfile(StudentProfile studentProfile);

    void deleteStudentProfile(StudentProfile studentProfile);
}
