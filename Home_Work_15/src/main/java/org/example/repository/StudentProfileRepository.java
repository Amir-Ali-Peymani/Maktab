package org.example.repository;


import org.example.entity.StudentProfile;

import java.util.List;

public interface StudentProfileRepository {

    void saveStudentprofile(StudentProfile studentProfile);

    StudentProfile getStudentProfileById(Long id);

    List<StudentProfile> getAllStudentProfiles();

    void updateStudentProfile(StudentProfile studentProfile);

    void deleteStudentProfile(StudentProfile studentProfile);
}
