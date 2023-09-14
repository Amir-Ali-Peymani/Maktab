package org.example.repository;

import org.example.entity.Semester;

import java.util.List;

public interface SemesterRepository {

    void saveSemester(Semester semester);

    Semester getSemesterById(Long id);

    List<Semester> getAllSemesters();

    void updateSemester(Semester semester);

    void deleteSemester(Semester semester);

}
