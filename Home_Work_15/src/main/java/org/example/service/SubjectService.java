package org.example.service;

import org.example.entity.Subject;

import java.util.List;

public interface SubjectService {

    void saveSubject(Subject subject);

    Subject getSubjectById(Long id);

    List<Subject> getAllSubject();

    void updateSubject(Subject subject);

    void deleteSubject(Subject subject);
}
