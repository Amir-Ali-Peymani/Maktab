package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.EducationalLoan;
import org.example.repository.EducationalLoanRepository;

import java.util.List;

public class EducationalLoanRepositoryImpl extends BaseRepository implements EducationalLoanRepository {

    @Override
    public void saveEducationalLoan(EducationalLoan educationalLoan) {
        em.getTransaction().begin();
        em.persist(educationalLoan);
        em.getTransaction().commit();
    }

    @Override
    public EducationalLoan getEducationalLoanById(Long id) {
        EducationalLoan educationalLoan = em.find(EducationalLoan.class, id);
        return educationalLoan;
    }

    @Override
    public List<EducationalLoan> getAllEducationalLoan() {
        List<EducationalLoan> educationalLoans =
                em.createQuery("SELECT e FROM EducationalLoan e", EducationalLoan.class).getResultList();
        return educationalLoans;
    }

    @Override
    public void updateEducationalLoan(EducationalLoan educationalLoan) {
        em.getTransaction().begin();
        em.merge(educationalLoan);
        em.getTransaction().commit();
    }

    @Override
    public void deleteEducationalLoan(EducationalLoan educationalLoan) {
        em.getTransaction().begin();
        em.remove(em.contains(educationalLoan) ? educationalLoan : em.merge(educationalLoan));
        em.getTransaction().commit();
    }
}
