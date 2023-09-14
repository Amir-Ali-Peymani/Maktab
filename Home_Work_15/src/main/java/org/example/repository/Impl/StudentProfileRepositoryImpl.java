package org.example.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.base.BaseRepository;
import org.example.entity.StudentProfile;
import org.example.repository.StudentProfileRepository;

import java.util.List;

public class StudentProfileRepositoryImpl extends BaseRepository implements StudentProfileRepository {

    @Override
    public void saveStudentprofile(StudentProfile studentProfile) {
        em.getTransaction().begin();
        em.persist(studentProfile);
        em.getTransaction().commit();
    }

    @Override
    public StudentProfile getStudentProfileById(Long id) {
        StudentProfile studentProfile = em.find(StudentProfile.class, id);
        return studentProfile;
    }

    @Override
    public List<StudentProfile> getAllStudentProfiles() {
        List<StudentProfile> studentsProfiles =
                em.createQuery("SELECT s FROM StudentProfile s", StudentProfile.class).getResultList();
        return studentsProfiles;
    }

    @Override
    public void updateStudentProfile(StudentProfile studentProfile) {
        em.getTransaction().begin();
        em.merge(studentProfile);
        em.getTransaction().commit();
    }

    @Override
    public void deleteStudentProfile(StudentProfile studentProfile) {
        em.getTransaction().begin();
        em.remove(em.contains(studentProfile) ? studentProfile: em.merge(studentProfile));
        em.getTransaction().commit();
    }

}
