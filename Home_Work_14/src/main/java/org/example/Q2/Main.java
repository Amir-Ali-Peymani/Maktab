package org.example.Q2;

import org.example.Q2.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        Person person = new Person();
        person.setName("amirali");
        person.setLastName("Peymani");
        person.setBirthDate(LocalDate.of(2000,3,2));
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }
}
