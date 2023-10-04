package org.example.Q1.service;

import org.example.Q1.entity.Person;

import java.util.List;

public interface PersonService {

    void savePerson(Person person);

    Person getPersonById(long id);

    List<Person> getAllPerson();

    void updatePerson(Person person);

    void deletePerson(Person person);

}

