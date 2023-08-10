package org.example.Q2.repository.impl;

import org.example.Q2.entity.Person;
import org.example.Q2.repository.PersonRepository;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class PersonRepositoryImpl implements PersonRepository {

    private final EntityManager entityManager;


    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAll() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Person.class, id));
    }

    @Override
    public Person save(Person person) {
        if (person.getId() == null) {
            entityManager.persist(person);
        } else {
            entityManager.merge(person);
        }
        return person;
    }

    @Override
    public void deleteById(Long id) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
    }
}
