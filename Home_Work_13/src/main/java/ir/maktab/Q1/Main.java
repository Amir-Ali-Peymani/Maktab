package ir.maktab.Q1;


import ir.maktab.Q1.mockdata.MockData;
import ir.maktab.Q1.model.Person;
import ir.maktab.Q1.model.PersonSummary;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> peopleList = MockData.getPeople();

        List<Person> filteredPeopleList = filterAge(peopleList);

        List<Person> orderingPeopleList = orderByUsername(peopleList);

        List<Person> filteredOrderingPeopleList = orderingByAgeByLastName(peopleList);

//        maping(peopleList);
        Map<String, String> result = filterAndMapPerson(peopleList);

        List<PersonSummary> correctingDate = convertAndCorrectBirthDates(peopleList);

        System.out.println(getAverageAge(peopleList));

    }

    public static List<Person> filterAge(List<Person> people) {
        List<Person> overfifty = people.stream()
                .filter(person -> person.getAge() > 50)
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
        List<Person> sortedList = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getLastName))
                .toList();
        return sortedList;
    }

    public static void maping(List<Person> people) {
        List<String> ipv4 = people.stream()
                .map(Person::getIpv4)
                .collect(Collectors.toList());
        System.out.println(ipv4);
    }

    public static Map<String, String> filterAndMapPerson(List<Person> people) {
        return people.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .filter(person -> person.getGender().equals("Female") && person.getAge() > 40)
                .dropWhile(person -> person.getFirstName().startsWith("a"))
                .limit(100)
                .collect(Collectors.toMap(
                        Person::getFirstName,
                        Person::getLastName,
                        (existingValue, newValue) -> (String) existingValue));
    }

    public static List<PersonSummary> convertAndCorrectBirthDates(List<Person> people) {
        return people.stream().map(person -> new PersonSummary(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getAge(),
                formatBirthDate(person.getAge())
        ))
                .collect(Collectors.toList());
    }

    private static String formatBirthDate(Integer age) {
        if (age <= 0){
            return "";
        } else {
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = currentDate.minusYears(age);
            return birthDate.format(DateTimeFormatter.ISO_DATE);
        }
    }

    private static double getAverageAge(List<Person> people) {
        return people.stream()
                .filter(person -> "male".equalsIgnoreCase(person.getGender()))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }
}