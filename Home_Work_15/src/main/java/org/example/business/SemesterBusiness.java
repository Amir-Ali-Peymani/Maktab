package org.example.business;

import org.example.entity.Semester;
import org.example.repository.Impl.SemesterRepositoryImpl;
import org.example.repository.SemesterRepository;
import org.example.service.Impl.SemesterServiceImpl;
import org.example.service.SemesterService;

import java.util.List;

public class SemesterBusiness {

    private static final SemesterRepository semesterRepository = new SemesterRepositoryImpl();

    private static final SemesterService semesterService = new SemesterServiceImpl(semesterRepository);


    public static void createSemester(String name){
        Semester semester = new Semester();
        semester.setName(name);
        semesterService.saveSemester(semester);
    }

    public static Semester getSemesterById(Long id){
        return semesterService.getSemesterById(id);
    }

    public static List<Semester> getAllSemester() {
        return semesterService.getAllSemesters();
    }

    public static void updateSemester(Long id, String name){
        Semester semester = semesterService.getSemesterById(id);
        if (semester != null){
            semester.setName(name);
        }
    }

    public static void deleteSemester(Long id){
        Semester semester = semesterService.getSemesterById(id);
        if (semester != null){
            semesterService.deleteSemester(semester);
        }
    }
}
