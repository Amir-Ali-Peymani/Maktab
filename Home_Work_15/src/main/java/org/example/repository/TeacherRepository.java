package org.example.repository;

import org.example.entity.Teacher;

import java.util.List;

public interface TeacherRepository {

    void saveTeacher(Teacher teacher);

    Teacher getTeacherById(Long id);

    List<Teacher> getAllTeachers();

    void updateTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

}
