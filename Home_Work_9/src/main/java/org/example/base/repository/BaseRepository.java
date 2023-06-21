package org.example.base.repository;

import org.example.base.entity.BaseEntity;

import java.io.Serializable;
import java.sql.SQLException;

public interface BaseRepository<ID extends Serializable, TYPE extends BaseEntity<ID>> {
    void save(TYPE entity) throws SQLException;

    void delete(ID id) throws SQLException;

    TYPE findById(ID id) throws SQLException;

    void update(TYPE entity) throws SQLException;
}
