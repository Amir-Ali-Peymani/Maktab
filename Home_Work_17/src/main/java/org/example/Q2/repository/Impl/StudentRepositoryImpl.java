package org.example.Q2.repository.Impl;

import org.example.Q2.base.BaseRepository;
import org.example.Q2.entity.Student;
import org.example.Q2.repository.StudentRepository;

import java.util.List;
public class StudentRepositoryImpl extends BaseRepository implements StudentRepository {
    @Override
    public void saveStudent(Student student) {

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public Student getStudentById(long id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudent() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public void updateStudent(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public void deleteStudent(Student student) {
        em.getTransaction().begin();
        em.remove(em.contains(student) ? student : em.merge(student));
        em.getTransaction().commit();
    }
}
