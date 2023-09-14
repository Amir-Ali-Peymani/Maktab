package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Semester;
import org.example.repository.SemesterRepository;

import java.util.List;

public class SemesterRepositoryImpl extends BaseRepository implements SemesterRepository {

    @Override
    public void saveSemester(Semester semester) {
        em.getTransaction().begin();
        em.persist(semester);
        em.getTransaction().commit();
    }

    @Override
    public Semester getSemesterById(Long id) {
        Semester semester = em.find(Semester.class, id);
        return semester;
    }

    @Override
    public List<Semester> getAllSemesters() {
        List<Semester> semester =
                em.createQuery("SELECT s FROM Semester s", Semester.class).getResultList();
        return semester;
    }

    @Override
    public void updateSemester(Semester semester) {
        em.getTransaction().begin();
        em.merge(semester);
        em.getTransaction().commit();
    }

    @Override
    public void deleteSemester(Semester semester) {
        em.getTransaction().begin();
        em.remove(em.contains(semester) ? semester : em.merge(semester));
        em.getTransaction().commit();
    }
}
