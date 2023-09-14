package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Course;
import org.example.repository.CourseRepository;

import java.util.List;

public class CourseRepositoryImpl extends BaseRepository implements CourseRepository {
    @Override
    public void saveCourse(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    @Override
    public Course getCourseById(Long id) {
        Course course = em.find(Course.class, id);
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses =
                em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
        return courses;
    }

    @Override
    public void updateCourse(Course course) {
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
    }

    @Override
    public void deleteCourse(Course course) {
        em.getTransaction().begin();
        em.remove(em.contains(course) ? course : em.merge(course));
        em.getTransaction().commit();
    }
}
