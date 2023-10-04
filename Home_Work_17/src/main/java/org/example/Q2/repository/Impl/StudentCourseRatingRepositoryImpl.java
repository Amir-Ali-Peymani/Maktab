package org.example.Q2.repository.Impl;

import org.example.Q2.base.BaseRepository;
import org.example.Q2.entity.StudentCourseRating;
import org.example.Q2.repository.StudentCourseRatingRepository;

import java.util.List;

public class StudentCourseRatingRepositoryImpl extends BaseRepository implements StudentCourseRatingRepository {
    @Override
    public void saveStudentCourseRating(StudentCourseRating studentCourseRating) {
        em.getTransaction().begin();
        em.persist(studentCourseRating);
        em.getTransaction().commit();
    }

    @Override
    public StudentCourseRating getStudentCourseRatingById(Long id) {
        return em.find(StudentCourseRating.class, id);
    }

    @Override
    public List<StudentCourseRating> getAllStudentCourse() {
        return em.createQuery("SELECT s FROM StudentCourseRating  s", StudentCourseRating.class).getResultList();
    }

    @Override
    public void updateStudentCourseRating(StudentCourseRating studentCourseRating) {
        em.getTransaction().begin();
        em.remove(em.contains(studentCourseRating) ? studentCourseRating : em.merge(studentCourseRating));
        em.getTransaction().commit();
    }

    @Override
    public void deleteStudentCourseRating(StudentCourseRating studentCourseRating) {
        em.getTransaction().begin();
        em.remove(em.contains(studentCourseRating) ? studentCourseRating : em.merge(studentCourseRating));
        em.getTransaction().commit();
    }
}
