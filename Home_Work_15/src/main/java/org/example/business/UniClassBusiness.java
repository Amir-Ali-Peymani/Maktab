package org.example.business;

import org.example.entity.Course;
import org.example.entity.Student;
import org.example.entity.UniClass;
import org.example.repository.Impl.UniClassRepositoryImpl;
import org.example.repository.UniClassRepository;
import org.example.service.Impl.UniClassServiceImpl;
import org.example.service.UniClassService;

import java.util.List;

public class UniClassBusiness {

    private static final UniClassRepository uniClassRepository = new UniClassRepositoryImpl();

    private static final UniClassService uniClassService = new UniClassServiceImpl(uniClassRepository);

    public static void createUniClass(String name, int score, Course course, Student student){
        UniClass uniClass = new UniClass();
        uniClass.setName(name);
        uniClass.setScore(score);
        uniClass.setCourse(course);
        uniClass.setStudent(student);
        uniClassService.saveUniClass(uniClass);
    }

    public static UniClass getUniClassById(Long id){
        return uniClassService.getUniClassById(id);
    }

    public static List<UniClass> getAllUniClass(){
        return uniClassService.getAllUniClasses();
    }

    public static void updateUniClass(Long id, int score){
       UniClass uniClass = uniClassService.getUniClassById(id);
       if (uniClass != null){
           uniClass.setScore(score);
       }
    }

    public static void deleteUniClass(Long id){
        UniClass uniClass = uniClassService.getUniClassById(id);
        if (uniClass != null){
            uniClassService.deleteUniClass(uniClass);
        }
    }

}
