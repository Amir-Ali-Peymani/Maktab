package org.example.service;

import org.example.entity.HousingDepositLoan;
import org.example.entity.StudentProfile;

import java.util.List;

public interface HousingDepositLoanService {

    void saveHousingDepositLoan(HousingDepositLoan housingDepositLoan);

    HousingDepositLoan getHousingDepositLoanById(Long id);

    List<HousingDepositLoan> getAllHousingDeposites();

    void updateHousingDeposites(HousingDepositLoan housingDepositLoan);

    void deleteHousingDeposites(HousingDepositLoan housingDepositLoan);
}
