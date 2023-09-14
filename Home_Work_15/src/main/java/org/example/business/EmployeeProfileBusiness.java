package org.example.business;

import org.example.entity.EmployeeProfile;
import org.example.repository.EmployeeProfileRepository;
import org.example.repository.Impl.EmployeeProfileRepositoryImpl;
import org.example.service.EmployeeProfileService;
import org.example.service.Impl.EmployeeProfileServiceImpl;

import java.util.List;

public class EmployeeProfileBusiness {

    private static final EmployeeProfileRepository  employeeProfileRepository = new EmployeeProfileRepositoryImpl();

    private static final EmployeeProfileService employeeProfileService = new EmployeeProfileServiceImpl(employeeProfileRepository);


    public static EmployeeProfile createEmployeeProfile(String userName, String password, String email){
        EmployeeProfile employeeProfile = new EmployeeProfile();
        employeeProfile.setUserName(userName);
        employeeProfile.setPassword(password);
        employeeProfile.setEmail(email);
        return employeeProfile;
    }

    public static EmployeeProfile getEmployeeProfileById(Long id) {
        return employeeProfileService.getEmployeeProfileById(id);
    }

    public static List<EmployeeProfile> getAllEmployees() {
        return employeeProfileService.getAllEmployeeProfiles();
    }

    public static void updateEmployeeProfile(Long id, String userName, String  password , String email){
        EmployeeProfile employeeProfile = employeeProfileService.getEmployeeProfileById(id);
        if (employeeProfile != null){
            employeeProfile.setUserName(userName);
            employeeProfile.setPassword(password);
            employeeProfile.setEmail(email);
            employeeProfileService.updateEmployeeProfile(employeeProfile);
        }
    }

    public static void deleteEmployeeProfile(Long id){
        EmployeeProfile employeeProfile = employeeProfileService.getEmployeeProfileById(id);
        if (employeeProfile != null){
            employeeProfileService.deleteEmployeeProfile(employeeProfile);
        }
    }
}
