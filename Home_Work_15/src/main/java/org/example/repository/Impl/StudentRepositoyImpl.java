package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Student;
import org.example.repository.StudentRepository;

import java.util.List;

public class StudentRepositoyImpl extends BaseRepository implements StudentRepository {

    @Override
    public void saveStudent(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = em.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students =
                em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        return students;
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
