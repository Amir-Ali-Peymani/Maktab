package org.example.service.Impl;

import org.example.entity.TeacherProfile;
import org.example.repository.TeacherProfileRepository;
import org.example.service.TeacherProfileService;

import java.util.List;

public class TeacherProfileServiceImpl implements TeacherProfileService {

    private final TeacherProfileRepository teacherProfileRepository;

    public TeacherProfileServiceImpl(TeacherProfileRepository teacherProfileRepository) {
        this.teacherProfileRepository = teacherProfileRepository;
    }
    @Override
    public void saveTeacherProfile(TeacherProfile teacherProfile) {
        teacherProfileRepository.saveTeacherProfile(teacherProfile);
    }

    @Override
    public TeacherProfile getTeacherProfileById(Long id) {
        return  teacherProfileRepository.getTeacherProfileById(id);
    }

    @Override
    public List<TeacherProfile> getAllTeacherProfiles() {
        return teacherProfileRepository.getAllTeacherProfiles();
    }

    @Override
    public void updateTeacherProfile(TeacherProfile teacherProfile) {
        teacherProfileRepository.updateTeacherProfile(teacherProfile);
    }

    @Override
    public void deleteTeacherProfile(TeacherProfile teacherProfile) {
        teacherProfileRepository.deleteTeacherProfile(teacherProfile);
    }
}
