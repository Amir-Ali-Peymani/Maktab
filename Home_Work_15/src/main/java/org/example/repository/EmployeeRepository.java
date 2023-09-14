package org.example.repository;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    void saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    void updateEmployees(Employee employee);

    void deleteEmployee(Employee employee);
}
