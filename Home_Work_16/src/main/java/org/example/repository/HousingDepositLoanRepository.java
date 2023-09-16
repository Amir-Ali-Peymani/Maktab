package org.example.repository;

import org.example.entity.HousingDepositLoan;

import java.util.List;

public interface HousingDepositLoanRepository {

    void saveHousingDepositLoan(HousingDepositLoan housingDepositLoan);

    HousingDepositLoan getHousingDepositLoanById(Long id);

    List<HousingDepositLoan> getAllHousingDeposites();

    void updateHousingDeposites(HousingDepositLoan housingDepositLoan);

    void deleteHousingDeposites(HousingDepositLoan housingDepositLoan);
}
