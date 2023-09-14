package org.example.business;

import org.example.entity.Subject;
import org.example.repository.Impl.SubjectRepositoryImpl;
import org.example.repository.SubjectRepository;
import org.example.service.Impl.SubjectServiceImpl;
import org.example.service.SubjectService;

import java.util.List;

public class SubjectBusiness {

    private static final SubjectRepository subjectRepository = new SubjectRepositoryImpl();

    private static final SubjectService subjectService = new SubjectServiceImpl(subjectRepository);

    public static void createSubject(String name){
        Subject subject = new Subject();
        subject.setName(name);
        subjectService.saveSubject(subject);
    }


    public static Subject getSubject(Long id){
        return subjectService.getSubjectById(id);
    }

    public static List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    public static void updateSubject(Long id, String name){
        Subject subject = subjectService.getSubjectById(id);
        if (subject != null){
            subject.setName(name);
            subjectService.updateSubject(subject);
        }
    }

    public static void deleteSubject(Long id){
        Subject subject = subjectService.getSubjectById(id);
        if (subject != null){
            subjectService.deleteSubject(subject);
        }
    }
}
