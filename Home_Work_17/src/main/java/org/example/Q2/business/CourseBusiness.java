package org.example.Q2.business;

import org.example.Q2.entity.Course;
import org.example.Q2.entity.Student;
import org.example.Q2.repository.CourseRepository;
import org.example.Q2.repository.Impl.CourseRepositoryImpl;
import org.example.Q2.service.CourseService;
import org.example.Q2.service.Impl.CourseServiceImpl;

import java.util.List;

public class CourseBusiness {

    private static final CourseRepository courseRepository = new CourseRepositoryImpl();

    private static final CourseService courseService = new CourseServiceImpl(courseRepository);

    public static Course createCourse(String courseName, Student student) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setStudent(student);
        return course;
    }

    public static Course getCourseById(Long id) {
        return courseService.getCourseById(id);
    }

    public static List<Course> getCourseList() {
        return courseService.getAllCourse();
    }


    public static void updateCourse(long id, String courseName, Student student) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            course.setCourseName(courseName);
            course.setStudent(student);
        }
    }

    public static void deleteCourse(long id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            courseService.deleteCourse(course);
        }
    }
}
