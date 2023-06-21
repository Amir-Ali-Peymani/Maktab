package org.example.base.service;

import java.sql.SQLException;

public interface BaseService <ID , TYPE>{

    void save (TYPE entity) throws SQLException;

    void delete(ID id) throws SQLException;

    TYPE findById(ID id) throws SQLException;

    void update(TYPE entity) throws SQLException;
}
