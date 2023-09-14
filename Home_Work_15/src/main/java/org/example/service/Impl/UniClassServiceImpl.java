package org.example.service.Impl;

import org.example.entity.UniClass;
import org.example.repository.UniClassRepository;
import org.example.service.UniClassService;

import java.util.List;

public class UniClassServiceImpl implements UniClassService {

    private final UniClassRepository uniClassRepository;

    public UniClassServiceImpl(UniClassRepository uniClassRepository) {
        this.uniClassRepository = uniClassRepository;
    }

    @Override
    public void saveUniClass(UniClass uniClass) {
        uniClassRepository.saveUniClass(uniClass);
    }

    @Override
    public UniClass getUniClassById(Long id) {
        return uniClassRepository.getUniClassById(id);
    }

    @Override
    public List<UniClass> getAllUniClasses() {
        return uniClassRepository.getAllUniClasses();
    }

    @Override
    public void updateUniClass(UniClass uniClass) {
        uniClassRepository.updateUniClass(uniClass);
    }

    @Override
    public void deleteUniClass(UniClass uniClass) {
        uniClassRepository.deleteUniClass(uniClass);
    }

}
