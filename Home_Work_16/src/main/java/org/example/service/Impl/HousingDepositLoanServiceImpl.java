package org.example.service.Impl;

import org.example.entity.HousingDepositLoan;
import org.example.repository.HousingDepositLoanRepository;
import org.example.service.HousingDepositLoanService;

import java.util.List;

public class HousingDepositLoanServiceImpl implements HousingDepositLoanService {

    private final HousingDepositLoanRepository housingDepositLoanRepository;


    public HousingDepositLoanServiceImpl(HousingDepositLoanRepository housingDepositLoanRepository){
        this.housingDepositLoanRepository = housingDepositLoanRepository;
    }


    @Override
    public void saveHousingDepositLoan(HousingDepositLoan housingDepositLoan) {
        housingDepositLoanRepository.saveHousingDepositLoan(housingDepositLoan);
    }

    @Override
    public HousingDepositLoan getHousingDepositLoanById(Long id) {
        return housingDepositLoanRepository.getHousingDepositLoanById(id);
    }

    @Override
    public List<HousingDepositLoan> getAllHousingDeposites() {
        return housingDepositLoanRepository.getAllHousingDeposites();
    }

    @Override
    public void updateHousingDeposites(HousingDepositLoan housingDepositLoan) {
        housingDepositLoanRepository.updateHousingDeposites(housingDepositLoan);
    }

    @Override
    public void deleteHousingDeposites(HousingDepositLoan housingDepositLoan) {
        housingDepositLoanRepository.deleteHousingDeposites(housingDepositLoan);
    }
}
