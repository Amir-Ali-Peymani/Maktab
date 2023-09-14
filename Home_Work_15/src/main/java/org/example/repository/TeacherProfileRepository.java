package org.example.repository;

import org.example.entity.TeacherProfile;

import java.util.List;

public interface TeacherProfileRepository {

    void saveTeacherProfile(TeacherProfile teacherProfile);

    TeacherProfile getTeacherProfileById(Long id);

    List<TeacherProfile> getAllTeacherProfiles();

    void updateTeacherProfile(TeacherProfile teacherProfile);

    void deleteTeacherProfile(TeacherProfile teacherProfile);
}