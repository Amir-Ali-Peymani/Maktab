package org.example.repository;

import org.example.entity.Subject;

import java.util.List;

public interface SubjectRepository {

    void saveSubject(Subject subject);

    Subject getSubjectById(Long id);

    List<Subject> getAllSubjects();

    void updateSubject(Subject subject );

    void deleteSubject(Subject subject);
}
