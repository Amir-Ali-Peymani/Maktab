package org.example.Q1;

import org.example.Q1.business.PersonBusiness;
import org.example.Q1.entity.Person;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate specificDate = LocalDate.of(2023, 10, 4);
        PersonBusiness.createPersonBusiness("John","peymania", specificDate );

        PersonBusiness.getPersonById(1L);

        PersonBusiness.getAllPerson();

        PersonBusiness.updatePerson(1L, "jhon", "abassy", specificDate);

        PersonBusiness.deletePerson(1L);

    }
}
