package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Course;
import org.example.repository.CourseRepository;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl  implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourses();
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.updateCourse(course);
    }

    @Override
    public void deleteCourse(Course course) {
        courseRepository.deleteCourse(course);
    }
}
