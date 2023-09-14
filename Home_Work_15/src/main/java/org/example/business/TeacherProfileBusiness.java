package org.example.business;


import org.example.entity.TeacherProfile;
import org.example.repository.Impl.TeacherProfileRepositoryImpl;
import org.example.repository.TeacherProfileRepository;
import org.example.service.Impl.TeacherProfileServiceImpl;
import org.example.service.TeacherProfileService;

import java.util.List;

public class TeacherProfileBusiness {

    private static final TeacherProfileRepository teacherProfileRepository = new TeacherProfileRepositoryImpl();

    private static final TeacherProfileService teacherProfileService = new TeacherProfileServiceImpl(teacherProfileRepository);

    public static TeacherProfile createTeacherProfile(String userName, String password, String email){
        TeacherProfile teacherProfile = new TeacherProfile();
        teacherProfile.setUserName(userName);
        teacherProfile.setPassword(password);
        teacherProfile.setEmail(email);
        return teacherProfile;
    }

    public static TeacherProfile getTeacherProfileById(Long id) {
        return teacherProfileService.getTeacherProfileById(id);
    }

    public static List<TeacherProfile> getAllTeacherProfiles(){
        return teacherProfileService.getAllTeacherProfiles();
    }

    public static void updateTeacherProfile(Long id, String userName, String password, String email){
        TeacherProfile teacherProfile = teacherProfileService.getTeacherProfileById(id);
        if (teacherProfile != null){
            teacherProfile.setUserName(userName);
            teacherProfile.setPassword(password);
            teacherProfile.setEmail(email);
            teacherProfileService.updateTeacherProfile(teacherProfile);
        }

    }

    public static void deleteTeacherProfile(Long id){
        TeacherProfile teacherProfile = teacherProfileService.getTeacherProfileById(id);
        if (teacherProfile != null){
            teacherProfileService.deleteTeacherProfile(teacherProfile);
        }
    }

}
