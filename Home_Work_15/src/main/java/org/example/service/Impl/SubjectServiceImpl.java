package org.example.service.Impl;

import org.example.entity.Subject;
import org.example.repository.SubjectRepository;
import org.example.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void saveSubject(Subject subject) {
        subjectRepository.saveSubject(subject);
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.getSubjectById(id);
    }

    @Override
    public List<Subject> getAllSubject(){
        return subjectRepository.getAllSubjects();
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectRepository.updateSubject(subject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectRepository.deleteSubject(subject);
    }
}
