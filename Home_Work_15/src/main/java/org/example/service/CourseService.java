package org.example.service;

import org.example.entity.Course;

import java.util.List;

public interface CourseService {

    void saveCourse(Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();

    void updateCourse(Course course);

    void deleteCourse(Course course);
}
