package org.example.Q2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private LocalDateTime timeStamp;

    private double rating;

    private String comment;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;


}
