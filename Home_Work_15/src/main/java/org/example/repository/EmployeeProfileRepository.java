package org.example.repository;

import org.example.entity.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileRepository {

    void saveEmployeeProfile(EmployeeProfile employeeProfile);

    EmployeeProfile getEmployeeProfileById(Long id);

    List<EmployeeProfile> getAllEmployeeProfiles();

    void updateEmployeeProfile(EmployeeProfile employeeProfile);


    void deleteEmployeeProfile(EmployeeProfile employeeProfile);
}
