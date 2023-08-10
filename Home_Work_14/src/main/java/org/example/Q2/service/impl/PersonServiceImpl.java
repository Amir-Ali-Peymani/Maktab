package org.example.Q2.service.impl;

import org.example.Q2.entity.Person;
import org.example.Q2.repository.PersonRepository;
import org.example.Q2.service.PersonService;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(String name, String lastName, LocalDate birthDate) {
        Person person = new Person();
        person.setName(name);
        person.setLastName(lastName);
        person.setBirthDate(birthDate);

        return personRepository.save(person);
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person updatePerson(Long id, String name, String lastName, LocalDate birthDate) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setName(name);
            person.setLastName(lastName);
            person.setBirthDate(birthDate);
            return personRepository.save(person);
        }
        return null;
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public List<Person> loadAllPersons() {
        return personRepository.findAll();
    }
}
