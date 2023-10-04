package org.example.Q1.business;

import org.example.Q1.base.BaseRepository;
import org.example.Q1.entity.Person;
import org.example.Q1.repository.Impl.PersonRepositoryImpl;
import org.example.Q1.repository.PersonRepository;
import org.example.Q1.service.Impl.PersonServiceImpl;
import org.example.Q1.service.PersonService;

import java.time.LocalDate;
import java.util.List;

public class PersonBusiness  extends BaseRepository {

    private static final PersonRepository personRepository = new PersonRepositoryImpl();

    private static final PersonService personService = new PersonServiceImpl(personRepository);


    public static void createPersonBusiness(String name, String laseName, LocalDate date){
        Person person = new Person();
        person.setName(name);
        person.setLastName(laseName);
        person.setBirthDate(date);
        logger.info("Created person with name: {}, ID: {}", name, person.getId());
        personService.savePerson(person);

    }

    public static Person getPersonById(long id){
//        return personService.getPersonById(id);
        Person person = personService.getPersonById(id);
        if (person != null) {
            logger.info("Retrieved person with ID: {}", id);
        } else {
            logger.warn("Person with ID {} not found", id);
        }
        return person;
    }


    public static List<Person> getAllPerson(){
//        return personService.getAllPerson();
        List<Person> people = personService.getAllPerson();
        logger.info("Retrieved {} people", people.size());
        return people;
    }


    public static void updatePerson(long id, String name, String lastName, LocalDate birthDate){
//        Person person = personService.getPersonById(id);
//        if (person != null){
//            person.setName(name);
//            person.setLastName(lastName);
//            person.setBirthDate(birthDate);
//        }
        Person person = personService.getPersonById(id);
        if (person != null) {
            person.setName(name);
            person.setLastName(lastName);
            person.setBirthDate(birthDate);
            personService.updatePerson(person);
            logger.info("Updated person with ID: {}", person.getId());
        } else {
            logger.warn("Person with ID {} not found", id);
        }
    }

    public static void deletePerson(Long id){
//        Person person = personService.getPersonById(id);
//        if (person != null){
//            personService.deletePerson(person);
//        }
        Person person = personService.getPersonById(id);
        if (person != null) {
            personService.deletePerson(person);
            logger.info("Deleted person with ID: {}", id);
        } else {
            logger.warn("Person with ID {} not found", id);
        }
    }


}