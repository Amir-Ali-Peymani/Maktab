package org.example.Q2;

import org.example.Q2.business.CourseBusiness;
import org.example.Q2.business.StudentBusiness;
import org.example.Q2.business.StudentCourseRatingBusiness;
import org.example.Q2.entity.Course;
import org.example.Q2.entity.Student;
import org.example.Q2.entity.StudentCourseRating;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDateTime personOne = LocalDateTime.of(2019,07,31,19,10,13);
        StudentCourseRatingBusiness.createStudentCourseRating(
                personOne, 5.0, "Excellent teaching",
                CourseBusiness.createCourse("Java Servlet JSP and Hibernate", StudentBusiness.createStudent("praveen"))
        );

        LocalDateTime personTwo = LocalDateTime.of(2019,04,23, 9,48,58);
        StudentCourseRatingBusiness.createStudentCourseRating(
                personTwo, 4.5, "The course is great",
                CourseBusiness.createCourse("Java Microservices Masterclass", StudentBusiness.createStudent("Van Hoang"))
        );

        LocalDateTime personThree = LocalDateTime.of(2019,04,23, 9,48,58);
        StudentCourseRatingBusiness.createStudentCourseRating(
                personThree, 4.5
                , "The course is great",
                CourseBusiness.createCourse("Java Servlet JSP and Hibernate", StudentBusiness.createStudent("Van Hoang"))
        );

        LocalDateTime personFour = LocalDateTime.of( 2019,6,18, 2,50,17);
        StudentCourseRatingBusiness.createStudentCourseRating(
                personFour, 5.0, "Amazing experience after this course. Thank you, instructor",
                CourseBusiness.createCourse("Python for Data Science", StudentBusiness.createStudent("Dhara Patel"))
        );

        LocalDateTime personFive= LocalDateTime.of(2019,6,28, 21,46,56);
        StudentCourseRatingBusiness.createStudentCourseRating(
                personFive, 5.0, "Excellent teaching",
                CourseBusiness.createCourse("Great Experience, I love thi...", StudentBusiness.createStudent("Dhara Patel"))
        );

    }

}
