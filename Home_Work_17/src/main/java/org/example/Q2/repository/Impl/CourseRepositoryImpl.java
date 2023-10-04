package org.example.Q2.repository.Impl;

import org.example.Q2.base.BaseRepository;
import org.example.Q2.entity.Course;
import org.example.Q2.repository.CourseRepository;

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
        return em.find(Course.class, id);
    }

    @Override
    public List<Course> getAllCourse() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public void updateCourse(Course course) {
        em.getTransaction().begin();
        em.remove(em.contains(course) ? course : em.merge(course));
        em.getTransaction().commit();
    }

    @Override
    public void deleteCourse(Course course) {
        em.getTransaction().begin();
        em.remove(em.contains(course) ? course : em.merge(course));
        em.getTransaction().commit();
    }
}
