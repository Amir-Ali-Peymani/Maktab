package org.example.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.base.BaseRepository;
import org.example.entity.Subject;
import org.example.repository.SubjectRepository;

import java.util.List;

public class SubjectRepositoryImpl extends BaseRepository implements SubjectRepository {

    @Override
    public void saveSubject(Subject subject) {
        em.getTransaction().begin();
        em.persist(subject);
        em.getTransaction().commit();
    }

    @Override
    public Subject getSubjectById(Long id) {
        Subject subject = em.find(Subject.class, id);
        return subject;
    }

    @Override
    public List<Subject> getAllSubjects(){
        List<Subject> subjects =
                em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
        return subjects;
    }

    @Override
    public void updateSubject(Subject subject) {
        em.getTransaction().begin();
        em.merge(subject);
        em.getTransaction().commit();
    }

    @Override
    public void deleteSubject(Subject subject) {
        em.getTransaction().begin();
        em.remove(em.contains(subject) ? subject : em.merge(subject));
        em.getTransaction().commit();
    }

}
