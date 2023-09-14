package org.example.repository;

import org.example.entity.UniClass;

import java.util.List;

public interface UniClassRepository {

    void saveUniClass(UniClass uniClass);

    UniClass getUniClassById(Long id);

    List<UniClass> getAllUniClasses();

    void updateUniClass(UniClass uniClass);

    void deleteUniClass(UniClass uniClass);

}
