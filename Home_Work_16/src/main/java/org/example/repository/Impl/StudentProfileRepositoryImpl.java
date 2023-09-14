package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.StudentProfile;
import org.example.repository.StudentProfileRepository;

import java.util.List;

public class StudentProfileRepositoryImpl extends BaseRepository implements StudentProfileRepository {
    @Override
    public void saveStudent(StudentProfile studentProfile) {
        em.getTransaction().begin();
        em.persist(studentProfile);
        em.getTransaction().commit();
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        StudentProfile studentProfile = em.find(StudentProfile.class, id );
        return studentProfile;
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        List<StudentProfile> studentProfiles =
                em.createQuery("SELECT s FROM StudentProfile s", StudentProfile.class).getResultList();
        return studentProfiles;
    }

    @Override
    public void updateStudent(StudentProfile studentProfile) {
        em.getTransaction().begin();
        em.merge(studentProfile);
        em.getTransaction().commit();
    }

    @Override
    public void deleteStudent(StudentProfile studentProfile) {
        em.getTransaction().begin();
        em.remove(em.contains(studentProfile) ? studentProfile : em.merge(studentProfile));
        em.getTransaction().commit();
    }
}
