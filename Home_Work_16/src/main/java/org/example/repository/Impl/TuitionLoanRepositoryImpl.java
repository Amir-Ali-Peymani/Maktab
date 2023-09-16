package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.TuitionLoan;
import org.example.repository.TuitionLoanRepository;

import java.util.List;

public class TuitionLoanRepositoryImpl extends BaseRepository implements TuitionLoanRepository {
    @Override
    public void saveTuitionLoan(TuitionLoan tuitionLoan) {
        em.getTransaction().begin();
        em.persist(tuitionLoan);
        em.getTransaction().commit();
    }

    @Override
    public TuitionLoan getTuitionLoanById(Long id) {
        TuitionLoan tuitionLoan = em.find(TuitionLoan.class, id);
        return tuitionLoan;
    }

    @Override
    public List<TuitionLoan> getAllTuitionLoan() {
        List<TuitionLoan> tuitionLoans =
                em.createQuery("SELECT t FROM TuitionLoan  t", TuitionLoan.class).getResultList();
        return tuitionLoans;
    }

    @Override
    public void updateTuitionLoan(TuitionLoan tuitionLoan) {
        em.getTransaction().begin();
        em.merge(tuitionLoan);
        em.getTransaction().commit();
    }

    @Override
    public void deleteTuitionLoan(TuitionLoan tuitionLoan) {
        em.getTransaction().begin();
        em.remove(em.contains(tuitionLoan) ? tuitionLoan : em.merge(tuitionLoan));
        em.getTransaction().commit();
    }
}
