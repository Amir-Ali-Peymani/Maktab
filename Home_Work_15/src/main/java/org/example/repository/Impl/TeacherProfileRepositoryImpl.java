package org.example.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.base.BaseRepository;
import org.example.entity.TeacherProfile;
import org.example.repository.TeacherProfileRepository;

import java.util.List;

public class TeacherProfileRepositoryImpl extends BaseRepository implements TeacherProfileRepository {

    @Override
    public void saveTeacherProfile(TeacherProfile teacherProfile) {
        em.getTransaction().begin();
        em.persist(teacherProfile);
        em.getTransaction().commit();
    }

    @Override
    public TeacherProfile getTeacherProfileById(Long id) {
        TeacherProfile teacherProfile = em.find(TeacherProfile.class, id);
        return teacherProfile;
    }

    @Override
    public List<TeacherProfile> getAllTeacherProfiles() {
        List<TeacherProfile> teacherProfiles =
                em.createQuery("SELECT s FROM TeacherProfile s" , TeacherProfile.class).getResultList();
        return teacherProfiles;
    }

    @Override
    public void updateTeacherProfile(TeacherProfile teacherProfile) {
        em.getTransaction().begin();
        em.merge(teacherProfile);
        em.getTransaction().commit();
    }

    @Override
    public void deleteTeacherProfile(TeacherProfile teacherProfile) {
        em.getTransaction().begin();
        em.remove(em.contains(teacherProfile) ? teacherProfile : em.merge(teacherProfile));
        em.getTransaction().commit();
    }

}
