package org.example.service;

import org.example.entity.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    void saveEmployeeProfile(EmployeeProfile employeeProfile);

    EmployeeProfile getEmployeeProfileById(Long id);

    List<EmployeeProfile> getAllEmployeeProfiles();

    void updateEmployeeProfile(EmployeeProfile employeeProfile);


    void deleteEmployeeProfile(EmployeeProfile employeeProfile);
}
