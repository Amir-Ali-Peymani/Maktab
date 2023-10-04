package org.example.Q1.business;

import org.example.Q1.entity.Person;
import org.example.Q1.repository.Impl.PersonRepositoryImpl;
import org.example.Q1.repository.PersonRepository;
import org.example.Q1.service.Impl.PersonServiceImpl;
import org.example.Q1.service.PersonService;

import java.time.LocalDate;

public class PersonBusiness {

    private static final PersonRepository personRepository = new PersonRepositoryImpl();

    private static final PersonService personService = new PersonServiceImpl(personRepository);


    public static void createPersonBusiness(String name, String laseName, LocalDate date){
        Person person = new Person();
        person.setName(name);
        person.setLastName(laseName);
        person.setBirthDate(date);
        personService.savePerson(person);
    }



}
