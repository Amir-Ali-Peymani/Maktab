package org.example.Q1.base;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;


public class BaseRepository {
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    protected static EntityManager em = emf.createEntityManager();

    protected static final Scanner scanner = new Scanner(System.in);

}
