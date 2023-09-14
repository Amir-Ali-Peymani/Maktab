package org.example.repository.Impl;

import org.example.base.BaseRepository;
import org.example.entity.UniClass;
import org.example.repository.UniClassRepository;

import java.util.List;

public class UniClassRepositoryImpl extends BaseRepository implements UniClassRepository {

    @Override
    public void saveUniClass(UniClass uniClass) {
        em.getTransaction().begin();
        em.persist(uniClass);
        em.getTransaction().commit();
    }

    @Override
    public UniClass getUniClassById(Long id) {
        UniClass uniClass = em.find(UniClass.class, id);
        return uniClass;
    }

    @Override
    public List<UniClass> getAllUniClasses() {
        List<UniClass> uniClasses =
                em.createQuery("SELECT u FROM UniClass u " , UniClass.class).getResultList();
        return uniClasses;
    }

    @Override
    public void updateUniClass(UniClass uniClass) {
        em.getTransaction().begin();
        em.merge(uniClass);
        em.getTransaction().commit();
    }

    @Override
    public void deleteUniClass(UniClass uniClass) {
        em.getTransaction().begin();
        em.remove(em.contains(uniClass) ? uniClass : em.merge(uniClass));
        em.getTransaction().commit();
    }
}
