package org.example.Q1.business;

import org.example.Q1.entity.Person;
import org.example.Q1.repository.Impl.PersonRepositoryImpl;
import org.example.Q1.repository.PersonRepository;
import org.example.Q1.service.Impl.PersonServiceImpl;
import org.example.Q1.service.PersonService;

import java.time.LocalDate;
import java.util.List;

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

    public static Person getPersonById(long id){
        return personService.getPersonById(id);
    }


    public static List<Person> getAllPerson(){
        return personService.getAllPerson();
    }


    public static void updatePerson(long id, String name, String lastName, LocalDate birthDate){
        Person person = personService.getPersonById(id);
        if (person != null){
            person.setName(name);
            person.setLastName(lastName);
            person.setBirthDate(birthDate);
        }
    }

    public static void deletePerson(Long id){
        Person person = personService.getPersonById(id);
        if (person != null){
            personService.deletePerson(person);
        }
    }


}
