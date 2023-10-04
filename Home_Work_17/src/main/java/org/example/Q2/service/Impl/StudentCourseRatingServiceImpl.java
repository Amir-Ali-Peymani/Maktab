package org.example.Q2.service.Impl;

import org.example.Q2.entity.StudentCourseRating;
import org.example.Q2.repository.StudentCourseRatingRepository;
import org.example.Q2.service.StudentCourseRatingService;

import java.util.List;

public class StudentCourseRatingServiceImpl implements StudentCourseRatingService {

    private final StudentCourseRatingRepository studentCourseRatingRepository;

    public StudentCourseRatingServiceImpl(StudentCourseRatingRepository studentCourseRatingRepository){
        this.studentCourseRatingRepository = studentCourseRatingRepository;
    }

    @Override
    public void saveStudentCourseRating(StudentCourseRating studentCourseRating) {
        studentCourseRatingRepository.saveStudentCourseRating(studentCourseRating);
    }

    @Override
    public StudentCourseRating getStudentCourseRatingById(Long id) {
        return studentCourseRatingRepository.getStudentCourseRatingById(id);
    }

    @Override
    public List<StudentCourseRating> getAllStudentCourse() {
        return studentCourseRatingRepository.getAllStudentCourse();
    }

    @Override
    public void updateStudentCourseRating(StudentCourseRating studentCourseRating) {
        studentCourseRatingRepository.updateStudentCourseRating(studentCourseRating);
    }

    @Override
    public void deleteStudentCourseRating(StudentCourseRating studentCourseRating) {
        studentCourseRatingRepository.deleteStudentCourseRating(studentCourseRating);
    }
}
