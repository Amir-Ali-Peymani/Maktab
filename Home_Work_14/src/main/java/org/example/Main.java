package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        User user = new User();
        user.setName("Amiralis");
        user.setUsername("Aralis");
        user.setPassword("324234akhgt");
        Wallet wallet = new Wallet();
        wallet.setName("amiraliswallet");
        wallet.setAmount(23234234);
        wallet.setUser(user);
        user.setWallet(wallet);
        entityManager.persist(user);




        entityManager.getTransaction().commit();
        User user1 = entityManager.find(User.class, 1L);
        System.out.println(user1);



    }
}