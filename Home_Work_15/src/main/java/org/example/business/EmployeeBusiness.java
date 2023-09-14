package org.example.business;

import org.example.entity.Employee;
import org.example.entity.EmployeeProfile;
import org.example.repository.EmployeeRepository;
import org.example.repository.Impl.EmployeeRepositoryImpl;
import org.example.service.EmployeeService;
import org.example.service.Impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeBusiness {

    private static final EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    private static final EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);


    public static void createEmployee(String name, String lastName, EmployeeProfile studentProfile){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setEmployeeProfile(studentProfile);
        employeeService.saveEmployee(employee);
    }

    public static Employee getEmployeeById(Long id) {
        return employeeService.getEmployeeById(id);
    }

    public static List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public static void updateEmployee(Long id, String name , String lastName){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null){
            employee.setName(name);
            employee.setLastName(lastName);
            employeeService.updateEmployees(employee);
        }
    }

    public static void deleteEmployee(Long id){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null){
            employeeService.deleteEmployees(employee);
        }

    }

}
