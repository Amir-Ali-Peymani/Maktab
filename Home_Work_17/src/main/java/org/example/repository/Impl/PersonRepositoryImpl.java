package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Person;
import org.example.repository.PersonRepository;

import java.util.List;

public class PersonRepositoryImpl extends BaseRepository implements PersonRepository {
    @Override
    public void savePerson(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    @Override
    public Person getPersonById(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getAllPerson() {
        return em.createQuery("SELECT p FROM Person p" , Person.class).getResultList();
    }

    @Override
    public void updatePerson(Person person) {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    @Override
    public void deletePerson(Person person) {
        em.getTransaction().begin();
        em.remove(em.contains(person) ? person : em.merge(person));
        em.getTransaction().commit();
    }
}