package org.example.Q2.business;

import org.example.Q2.entity.Course;
import org.example.Q2.entity.StudentCourseRating;
import org.example.Q2.repository.Impl.StudentCourseRatingRepositoryImpl;
import org.example.Q2.repository.StudentCourseRatingRepository;
import org.example.Q2.service.Impl.StudentCourseRatingServiceImpl;
import org.example.Q2.service.StudentCourseRatingService;

import java.time.LocalDateTime;
import java.util.List;


public class StudentCourseRatingBusiness {

    private static final StudentCourseRatingRepository instance = new StudentCourseRatingRepositoryImpl();

    private static final StudentCourseRatingService instanceService = new StudentCourseRatingServiceImpl(instance);


    public static void createStudentCourseRating(LocalDateTime timestamp, double rating, String comment,
            Course course){
        StudentCourseRating studentCourseRating = new StudentCourseRating();
        studentCourseRating.setTimeStamp(timestamp);
        studentCourseRating.setRating(rating);
        studentCourseRating.setComment(comment);
        studentCourseRating.setCourse(course);
        instanceService.saveStudentCourseRating(studentCourseRating);
    }

    public static StudentCourseRating getStudentCourseRatingById(Long id){
        return instanceService.getStudentCourseRatingById(id);
    }

    public static List<StudentCourseRating> getStudentCourseRating(){
        return instanceService.getAllStudentCourse();
    }

    public static void updateStudentCourseRating(Long id, LocalDateTime timestamp, double rating, String comment,
                                                 Course course){
        StudentCourseRating studentCourseRating = instanceService.getStudentCourseRatingById(id);
        if (studentCourseRating != null){
            studentCourseRating.setTimeStamp(timestamp);
            studentCourseRating.setRating(rating);
            studentCourseRating.setComment(comment);
            studentCourseRating.setCourse(course);
        }
    }

    public static void deleteStudentCourseRating(Long id){
        StudentCourseRating studentCourseRating = instanceService.getStudentCourseRatingById(id);
        if (studentCourseRating != null){
            instanceService.deleteStudentCourseRating(studentCourseRating);
        }
    }
}
