package org.example.service;

import org.example.entity.Semester;

import java.util.List;

public interface SemesterService {

    void saveSemester(Semester semester);

    Semester getSemesterById(Long id);

    List<Semester> getAllSemesters();

    void updateSemester(Semester semester);

    void deleteSemester(Semester semester);
}
