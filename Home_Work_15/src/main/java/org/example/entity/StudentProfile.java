package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String userName;


    private String password;


    private String email;

    @OneToOne(mappedBy = "studentProfile")
    private Student student;

}
