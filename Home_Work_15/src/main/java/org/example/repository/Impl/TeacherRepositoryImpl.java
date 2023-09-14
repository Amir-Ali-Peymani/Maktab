package org.example.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.base.BaseRepository;
import org.example.entity.Teacher;
import org.example.repository.TeacherRepository;

import java.util.List;

public class TeacherRepositoryImpl extends BaseRepository implements TeacherRepository {

    @Override
    public void saveTeacher(Teacher teacher) {
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Teacher teacher = em.find(Teacher.class , id);
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
        return teachers;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        em.getTransaction().begin();
        em.remove(em.contains(teacher) ? teacher : em.merge(teacher));
        em.getTransaction().commit();
    }
}
