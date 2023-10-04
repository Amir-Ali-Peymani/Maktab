package org.example.Q2;

import org.example.Q2.entity.Course;
import org.example.Q2.entity.Student;
import org.example.Q2.entity.StudentCourseRating;

public class Main {
    private static final Student student = new Student();
    private static final Course course = new Course();
    private static final StudentCourseRating studentCourseRating = new StudentCourseRating();

    public static void main(String[] args) {
        student.setStudentName("Student");
        course.setStudent(student);
        course.setCourseName("Course");
        studentCourseRating.setCourse(course);

    }

}
