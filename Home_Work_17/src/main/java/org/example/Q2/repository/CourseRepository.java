package org.example.Q2.repository;

import org.example.Q2.entity.Course;

import java.util.List;

public interface CourseRepository {

    void saveCourse (Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourse();

    void updateCourse(Course course);

    void deleteCourse(Course course);

}