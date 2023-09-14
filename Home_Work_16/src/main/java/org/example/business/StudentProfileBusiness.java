package org.example.business;


import org.example.entity.StudentProfile;
import org.example.repository.Impl.StudentProfileRepositoryImpl;
import org.example.repository.StudentProfileRepository;
import org.example.service.Impl.StudentProfileServiceImpl;
import org.example.service.StudentProfileService;

import java.util.List;

public class StudentProfileBusiness {

    private static final StudentProfileRepository studentProfileRepository = new StudentProfileRepositoryImpl();

    private static final StudentProfileService studentProfileService = new StudentProfileServiceImpl(studentProfileRepository);

    public static StudentProfile createStudentProfileBusiness(String userName, String password, String email){
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setUserName(userName);
        studentProfile.setPassword(password);
        studentProfile.setEmail(email);
        return studentProfile;
    }

    public static StudentProfile getStudentProfileById(Long id){
        return studentProfileService.getStudentProfileById(id);
    }

    public static List<StudentProfile> getAllStudentProfiles(){
        return studentProfileService.getAllStudentsProfile();
    }

    public static void updateStudentProfile(Long id, String userName, String password, String email){
        StudentProfile studentProfile = studentProfileService.getStudentProfileById(id);
        if (studentProfile != null){
            studentProfile.setUserName(userName);
            studentProfile.setPassword(password);
            studentProfile.setEmail(email);
        }
    }

    public static void deleteStudentProfile(Long id){
        StudentProfile studentProfile = studentProfileService.getStudentProfileById(id);
        if (studentProfile != null){
            studentProfileService.deleteStudentProfile(studentProfile);
        }
    }
}
