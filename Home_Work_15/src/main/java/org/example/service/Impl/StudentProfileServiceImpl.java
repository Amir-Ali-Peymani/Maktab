package org.example.service.Impl;

import org.example.entity.StudentProfile;
import org.example.repository.StudentProfileRepository;
import org.example.service.StudentProfileService;

import java.util.List;

public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public void saveStudentProfile(StudentProfile studentProfile) {
        studentProfileRepository.saveStudentprofile(studentProfile);
    }

    @Override
    public StudentProfile getStudentProfileById(Long id) {
        return studentProfileRepository.getStudentProfileById(id);
    }

    @Override
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileRepository.getAllStudentProfiles();
    }

    @Override
    public void updateStudentProfile(StudentProfile studentProfile) {
        studentProfileRepository.updateStudentProfile(studentProfile);
    }

    @Override
    public void delteteStudentProfile(StudentProfile studentProfile) {
        studentProfileRepository.deleteStudentProfile(studentProfile);
    }
}
