package org.example.service.Impl;

import org.example.entity.EmployeeProfile;
import org.example.repository.EmployeeProfileRepository;
import org.example.repository.StudentProfileRepository;
import org.example.service.EmployeeProfileService;

import java.util.List;

public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository employeeProfileRepository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository employeeProfileRepository) {
        this.employeeProfileRepository = employeeProfileRepository;
    }

    @Override
    public void saveEmployeeProfile(EmployeeProfile employeeProfile) {
        employeeProfileRepository.saveEmployeeProfile(employeeProfile);
    }

    @Override
    public EmployeeProfile getEmployeeProfileById(Long id) {
        return employeeProfileRepository.getEmployeeProfileById(id);
    }

    @Override
    public List<EmployeeProfile> getAllEmployeeProfiles() {
        return employeeProfileRepository.getAllEmployeeProfiles();
    }

    @Override
    public void updateEmployeeProfile(EmployeeProfile employeeProfile) {
        employeeProfileRepository.updateEmployeeProfile(employeeProfile);
    }

    @Override
    public void deleteEmployeeProfile(EmployeeProfile employeeProfile) {
        employeeProfileRepository.deleteEmployeeProfile(employeeProfile);
    }
}
