package org.example.Q1.repository;

import org.example.Q1.entity.Person;

import java.util.List;

public interface PersonRepository {

    void savePerson(Person person);

    Person getPersonById(Long id);

    List<Person> getAllPerson();

    void updatePerson(Person person);

    void deletePerson(Person person);

}
