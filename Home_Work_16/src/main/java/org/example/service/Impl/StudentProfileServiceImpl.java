package org.example.service.Impl;

import org.example.entity.StudentProfile;
import org.example.repository.StudentProfileRepository;
import org.example.service.StudentProfileService;

import java.util.List;

public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository){
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public void saveStudentProfile(StudentProfile studentProfile) {
        studentProfileRepository.saveStudent(studentProfile);
    }

    @Override
    public StudentProfile getStudentProfileById(Long id) {
        return studentProfileRepository.getStudentById(id);
    }

    @Override
    public List<StudentProfile> getAllStudentsProfile() {
        return studentProfileRepository.getAllStudents();
    }

    @Override
    public void updateStudentProfile(StudentProfile studentProfile) {
        studentProfileRepository.updateStudent(studentProfile);
    }

    @Override
    public void deleteStudentProfile(StudentProfile studentProfile) {
        studentProfileRepository.deleteStudent(studentProfile);
    }

}
