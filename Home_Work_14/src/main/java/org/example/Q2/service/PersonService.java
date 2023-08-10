package org.example.Q2.service;

import org.example.Q2.entity.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person savePerson(String name, String lastName, LocalDate birthDate);

    Optional<Person> getPersonById(Long id);

    Person updatePerson(Long id, String name, String lastName, LocalDate birthDate);

    void deletePerson(Long id);

    List<Person> loadAllPersons();
}
