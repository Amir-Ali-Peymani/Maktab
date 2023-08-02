package ir.maktab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString

public class PersonSummary {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String birthDate;

    public PersonSummary(Integer id, String firstName, String lastName, Integer age, String birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }
}
