package org.example.repository.Impl;


import org.example.base.BaseRepository;
import org.example.entity.HousingDepositLoan;
import org.example.repository.HousingDepositLoanRepository;

import java.util.List;

public class HousingDepositLoanRespositoryImpl extends BaseRepository implements HousingDepositLoanRepository {


    @Override
    public void saveHousingDepositLoan(HousingDepositLoan housingDepositLoan) {
        em.getTransaction().begin();
        em.persist(housingDepositLoan);
        em.getTransaction().commit();
    }

    @Override
    public HousingDepositLoan getHousingDepositLoanById(Long id) {
        HousingDepositLoan housingDepositLoan = em.find(HousingDepositLoan.class, id);
        return housingDepositLoan;
    }

    @Override
    public List<HousingDepositLoan> getAllHousingDeposites() {
        List<HousingDepositLoan> housingDepositLoans =
                em.createQuery("SELECT h FROM HousingDepositLoan  h", HousingDepositLoan.class).getResultList();
        return housingDepositLoans;
    }

    @Override
    public void updateHousingDeposites(HousingDepositLoan housingDepositLoan) {
        em.getTransaction().begin();
        em.merge(housingDepositLoan);
        em.getTransaction().commit();
    }

    @Override
    public void deleteHousingDeposites(HousingDepositLoan housingDepositLoan) {
        em.getTransaction().begin();
        em.remove(em.contains(housingDepositLoan) ? housingDepositLoan : em.merge(housingDepositLoan));
        em.getTransaction().commit();
    }
}
