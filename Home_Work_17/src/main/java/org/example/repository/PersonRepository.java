package org.example.repository;

import org.example.entity.Person;

import java.util.List;

public interface PersonRepository {

    void savePerson(Person person);

    Person getPersonById(Long id);

    List<Person> getAllPerson();

    void updatePerson(Person person);

    void deletePerson(Person person);

}
