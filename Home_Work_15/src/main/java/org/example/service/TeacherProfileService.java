package org.example.service;

import org.example.entity.TeacherProfile;

import java.util.List;

public interface TeacherProfileService {

    void saveTeacherProfile(TeacherProfile teacherProfile);

    TeacherProfile getTeacherProfileById(Long id);

    List<TeacherProfile> getAllTeacherProfiles();

    void updateTeacherProfile(TeacherProfile teacherProfile);

    void deleteTeacherProfile(TeacherProfile teacherProfile);

}
