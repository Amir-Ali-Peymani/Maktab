package org.example.Q2.repository;

import org.example.Q2.entity.Student;
import org.example.Q2.entity.StudentCourseRating;

import java.util.List;

public interface StudentCourseRatingRepository {

    void saveStudentCourseRating(StudentCourseRating studentCourseRating);

    StudentCourseRating getStudentCourseRatingById(Long id);

    List<StudentCourseRating> getAllStudentCourse();

    void updateStudentCourseRating(StudentCourseRating studentCourseRating);

    void deleteStudentCourseRating(StudentCourseRating studentCourseRating);

}
