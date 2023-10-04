package org.example.Q2.service;

import org.example.Q2.entity.Course;

import java.util.List;

public interface CourseService {

    void saveCourse (Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();

    void updateCourse(Course course);

    void deleteCourse(Course course);
}
