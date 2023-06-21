package org.example.base.service.impl;

import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepository;
import org.example.base.service.BaseService;

import java.io.Serializable;
import java.sql.SQLException;

public class BaseServiceImpl <ID extends Serializable, TYPE extends BaseEntity<ID>,
        R extends BaseRepository<ID, TYPE>>
        implements BaseService<ID, TYPE> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void save(TYPE entity) throws SQLException {
        repository.save(entity);
    }

    @Override
    public void delete(ID id) throws SQLException {
        repository.delete(id);
    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        return repository.findById(id);
    }

    @Override
    public void update(TYPE entity) throws SQLException {
        repository.update(entity);
    }
}
