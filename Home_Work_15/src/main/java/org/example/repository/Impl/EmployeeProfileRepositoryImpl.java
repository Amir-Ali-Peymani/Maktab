package org.example.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.base.BaseRepository;
import org.example.entity.EmployeeProfile;
import org.example.repository.EmployeeProfileRepository;

import java.util.List;

public class EmployeeProfileRepositoryImpl extends BaseRepository implements EmployeeProfileRepository {

    @Override
    public void saveEmployeeProfile(EmployeeProfile employeeProfile) {
        em.getTransaction().begin();
        em.persist(employeeProfile);
        em.getTransaction().commit();
    }

    @Override
    public EmployeeProfile getEmployeeProfileById(Long id) {
        EmployeeProfile employeeProfile = em.find(EmployeeProfile.class, id);
        return employeeProfile;
    }

    @Override
    public List<EmployeeProfile> getAllEmployeeProfiles() {
        List<EmployeeProfile> employeeProfiles =
                em.createQuery("SELECT e FROM EmployeeProfile e ", EmployeeProfile.class).getResultList();
        return employeeProfiles;
    }

    @Override
    public void updateEmployeeProfile(EmployeeProfile employeeProfile) {
        em.getTransaction().begin();
        em.merge(employeeProfile);
        em.getTransaction().commit();
    }

    @Override
    public void deleteEmployeeProfile(EmployeeProfile employeeProfile) {
        em.getTransaction().begin();
        em.remove(em.contains(employeeProfile) ? employeeProfile : em.merge(employeeProfile));
        em.getTransaction().commit();
    }
}
