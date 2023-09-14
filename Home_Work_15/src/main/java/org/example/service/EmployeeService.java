package org.example.service;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    void updateEmployees(Employee employee);

    void deleteEmployees(Employee employee);
}
