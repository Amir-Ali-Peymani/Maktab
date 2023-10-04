package org.example.Q1.base;

import ch.qos.logback.classic.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.criterion.Example;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class BaseRepository {
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    protected static EntityManager em = emf.createEntityManager();

    protected static final Scanner scanner = new Scanner(System.in);

    protected static final Logger logger = (Logger) LoggerFactory.getLogger(BaseRepository.class);

}