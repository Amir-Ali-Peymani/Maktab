package org.example.repository;

import org.example.entity.Course;
import org.example.entity.Student;

import java.util.List;

public interface CourseRepository {

    void saveCourse(Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    void updateCourse(Course course);

    void deleteCourse(Course course);

}
