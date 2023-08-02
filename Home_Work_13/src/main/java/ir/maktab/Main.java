package ir.maktab;


import ir.maktab.mockdata.MockData;
import ir.maktab.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> peopleList = MockData.getPeople();

        List<Person> filteredPeopleList = filterAge(peopleList);

        List<Person> orderingPeopleList = orderByUsername(peopleList);
    }

    public static List<Person> filterAge(List<Person> people) {
        List<Person> overfifty = people.stream()
                .filter(person -> person.getAge() >50)
                .collect(Collectors.toList());
        return overfifty;
    }

    public static List<Person> orderByUsername(List<Person> people) {
        List<Person> orderedByUsername = people.stream()
                .sorted(Comparator.comparing(Person::getUsername))
                .toList();
        return orderedByUsername;
    }

    public static List<Person> orderingByAgeByLastName(List<Person> people) {


        return null;
    }
}