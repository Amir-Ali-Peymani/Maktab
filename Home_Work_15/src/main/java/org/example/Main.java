package org.example;


import org.example.entity.Student;
import org.example.entity.StudentProfile;
import org.example.entity.Subject;
import org.example.repository.Impl.StudentProfileRepositoryImpl;
import org.example.repository.Impl.StudentRepositoyImpl;
import org.example.repository.StudentProfileRepository;
import org.example.repository.StudentRepository;
import org.example.service.Impl.StudentProfileServiceImpl;
import org.example.service.Impl.StudentServiceImpl;
import org.example.service.StudentProfileService;
import org.example.service.StudentService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepositoyImpl();

        StudentService studentSevice = new StudentServiceImpl(studentRepository);

        StudentProfileRepository studentProfileRepository = new StudentProfileRepositoryImpl();

        StudentProfileService studentProfileService = new StudentProfileServiceImpl(studentProfileRepository);

        Student student = new Student();
        student.setName("john");
        student.setLastName("Doe");
        student.setGpa(33.3);



        StudentProfile profile = new StudentProfile();
        profile.setUserName("john_doe");
        profile.setPassword("password");
        profile.setEmail("alsdfjlajfsdlj");

        profile.setStudent(student);

        student.setStudentProfile(profile);

        studentSevice.saveStudent(student);

        studentProfileService.saveStudentProfile(profile);


    }
}