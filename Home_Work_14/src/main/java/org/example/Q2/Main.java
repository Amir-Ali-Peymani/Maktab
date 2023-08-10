package org.example.Q2;

import org.example.Q2.entity.Person;
import org.example.Q2.repository.impl.PersonRepositoryImpl;
import org.example.Q2.service.impl.PersonServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = emf.createEntityManager();
//
//        entityManager.getTransaction().begin();
//        Person person = new Person();
//        person.setName("amirali");
//        person.setLastName("Peymani");
//        person.setBirthDate(LocalDate.of(2000,3,2));
//        entityManager.persist(person);

        entityManager.getTransaction().begin();
        Person person = new Person();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl(entityManager);
        PersonServiceImpl service = new PersonServiceImpl(personRepository);
        service.savePerson("amrirali", "peyia", LocalDate.of(2000,3,2));
        entityManager.persist(service.savePerson("amrirali", "peyia", LocalDate.of(2000,3,2)));
        entityManager.persist(service.updatePerson(1L, "amirreza", "peyia", LocalDate.of(2000,3,2)));
        entityManager.getTransaction().commit();
        service.deletePerson(1L);
        service.loadAllPersons();
        service.getPersonById(1L);



    }
}
