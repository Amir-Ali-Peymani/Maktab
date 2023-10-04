package org.example.Q2.repository.Impl;

import org.example.Q2.base.BaseRepository;
import org.example.Q2.entity.Course;
import org.example.Q2.repository.CourseRepository;

import java.util.List;

public class CourseRepositoryImpl extends BaseRepository implements CourseRepository {
    @Override
    public void saveCourse(Course course) {
        em.getTransaction().begin();
        em
    }

    @Override
    public Course getCourseById(Long id) {
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return null;
    }

    @Override
    public void updateCourse(Course course) {

    }

    @Override
    public void deleteCourse(Course course) {

    }
}
