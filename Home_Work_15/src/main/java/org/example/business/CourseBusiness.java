package org.example.business;

import org.example.entity.Course;
import org.example.entity.Semester;
import org.example.entity.Subject;
import org.example.entity.Teacher;
import org.example.repository.CourseRepository;
import org.example.repository.Impl.CourseRepositoryImpl;
import org.example.service.CourseService;
import org.example.service.Impl.CourseServiceImpl;

import java.util.List;

public class CourseBusiness {

    private static final CourseRepository courseRepository = new CourseRepositoryImpl();

    private static final CourseService courseService = new CourseServiceImpl(courseRepository);

    public static void createCourseBusiness(Semester semester , Subject subject , Teacher teacher){
        Course course = new Course();
        course.setSemester(semester);
        course.setSubject(subject);
        course.setTeacher(teacher);
        courseService.saveCourse(course);
    }

    public static Course getCourseById(Long id){
        return courseService.getCourseById(id);
    }

    public static List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    public static void updateCourse(Long id, Semester semester, Subject subject, Teacher teacher){
        Course course = courseService.getCourseById(id);
        if (course != null){
            course.setSemester(semester);
            course.setSubject(subject);
            course.setTeacher(teacher);
        }

    }

    public static void deleteCourse(Long id){
        Course course = courseService.getCourseById(id);
        if (course != null){
            courseService.deleteCourse(course);
        }
    }

}
