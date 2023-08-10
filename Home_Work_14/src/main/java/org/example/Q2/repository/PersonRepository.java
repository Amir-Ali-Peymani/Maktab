package org.example.Q2.repository;

import org.example.Q2.entity.Person;


import java.util.List;
import java.util.Optional;


public interface PersonRepository {
    List<Person> findAll();
    Optional<Person> findById(Long id);
    Person save(Person person);
    void deleteById(Long id);
}
