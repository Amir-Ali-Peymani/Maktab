package org.example.service.Impl;

import org.example.entity.Semester;
import org.example.repository.SemesterRepository;
import org.example.service.SemesterService;

import java.util.List;

public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }


    @Override
    public void saveSemester(Semester semester) {
        semesterRepository.saveSemester(semester);
    }

    @Override
    public Semester getSemesterById(Long id) {
        return semesterRepository.getSemesterById(id);
    }

    @Override
    public List<Semester> getAllSemesters() {
        return semesterRepository.getAllSemesters();
    }

    @Override
    public void updateSemester(Semester semester) {
        semesterRepository.updateSemester(semester);
    }

    @Override
    public void deleteSemester(Semester semester) {
        semesterRepository.deleteSemester(semester);
    }
}
