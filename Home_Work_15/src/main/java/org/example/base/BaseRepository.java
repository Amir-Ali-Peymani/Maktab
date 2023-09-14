package org.example.base;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BaseRepository {
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    protected static EntityManager em = emf.createEntityManager();

}
