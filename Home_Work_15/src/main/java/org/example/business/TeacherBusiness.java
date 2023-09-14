package org.example.business;

import org.example.entity.Teacher;
import org.example.entity.TeacherProfile;
import org.example.repository.Impl.TeacherRepositoryImpl;
import org.example.repository.TeacherRepository;
import org.example.service.Impl.TeacherServiceImpl;
import org.example.service.TeacherService;

import java.util.List;

public class TeacherBusiness {

    private static final  TeacherRepository teacherRepository = new TeacherRepositoryImpl();

    private static final TeacherService teacherService = new TeacherServiceImpl(teacherRepository);


    public static void createTeacher(String name, String lastName, int salary, TeacherProfile teacherProfile){
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setLastName(lastName);
        teacher.setSalary(salary);
        teacher.setTeacherProfile(teacherProfile);
        teacherService.saveTeacher(teacher);
    }

    public static Teacher getTeacherById(Long id) {
        return teacherService.getTeacherById(id);
    }

    public static List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    public static void updateTeacher(Long id, String name, String lastName, int salary){
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher != null) {
            teacher.setName(name);
            teacher.setLastName(lastName);
            teacher.setSalary(salary);
            teacherService.updateTeacher(teacher);
        }
    }

    public static void deleteTeacher(Long id){
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher != null){
            teacherService.deleteTeacher(teacher);
        }
    }

}
