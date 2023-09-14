package org.example.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.base.BaseRepository;
import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;

import java.util.List;

public class EmployeeRepositoryImpl extends BaseRepository implements EmployeeRepository {

    @Override
    public void saveEmployee(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = em.find(Employee.class, id);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        return employees;
    }

    @Override
    public void updateEmployees(Employee employee) {
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        em.getTransaction().begin();
        em.remove(em.contains(employee) ? employee : em.merge(employee));
        em.getTransaction().commit();
    }
}
