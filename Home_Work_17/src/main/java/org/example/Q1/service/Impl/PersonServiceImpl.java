package org.example.Q1.service.Impl;

import org.example.Q1.entity.Person;
import org.example.Q1.repository.PersonRepository;
import org.example.Q1.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;

    }
    @Override
    public void savePerson(Person person) {
        personRepository.savePerson(person);
    }

    @Override
    public Person getPersonById(long id) {
        return personRepository.getPersonById(id);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.getAllPerson();
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.updatePerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.deletePerson(person);
    }
}