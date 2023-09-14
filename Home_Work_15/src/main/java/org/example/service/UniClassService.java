package org.example.service;

import org.example.entity.UniClass;

import java.util.List;

public interface UniClassService {

    void saveUniClass(org.example.entity.UniClass uniClass);

    UniClass getUniClassById(Long id);

    List<org.example.entity.UniClass> getAllUniClasses();

    void updateUniClass(org.example.entity.UniClass uniClass);

    void deleteUniClass(org.example.entity.UniClass uniClass);

}
