package org.example.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastName;

    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherProfile_id")
    private TeacherProfile teacherProfile;

    @OneToMany(mappedBy = "teacher")
    List<Course> courses;

}
