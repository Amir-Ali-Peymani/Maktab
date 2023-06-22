package org.example.base.repository.impl;

import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepository;
import org.example.config.MyConnection;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseRepositoryImpl <ID extends Serializable, TYPE extends BaseEntity<ID>>
        implements BaseRepository <ID, TYPE> {
    @Override
    public void save(TYPE entity) throws SQLException {
        String sql = "INSERT INTO " + getTableName() + " " + getColumnsName() + " VALUES ( " + getCountOfQuestionMarks() + ") ";
        try (PreparedStatement statement = new MyConnection().getConnection().prepareStatement(sql)){
            fillParamForStatement(statement, entity);
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(ID id) throws SQLException {
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ? ";
        try (PreparedStatement statement = new MyConnection().getConnection().prepareStatement(sql)) {
            statement.setInt(1, (Integer) id);
            statement.executeUpdate();
        }
    }

    @Override
    public TYPE findById(ID id) throws SQLException {
        String sql="SELECT * FROM "+getTableName()+ " WHERE id = ? ;";
        try (PreparedStatement statement=new MyConnection().getConnection().prepareStatement(sql)){
            statement.setInt(1, (Integer) id);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next())
                return mapResultSetToEntity(resultSet);
        }
        return null;
    }

    @Override
    public void update(TYPE entity) throws SQLException {
        String sql = "UPDATE " + getTableName() + " SET " + getUpdateQueryParams() + " WHERE id = ?";
        try (PreparedStatement statement = new MyConnection().getConnection().prepareStatement(sql)) {
            fillParamForStatement(statement, entity);
            statement.executeUpdate();
        }
    }

    public abstract String getTableName();

    public abstract String getColumnsName();

    public abstract String getUpdateQueryParams();

    public abstract String getCountOfQuestionMarks();

    public abstract TYPE mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    public abstract void fillParamForStatement(PreparedStatement preparedStatement, TYPE entity) throws SQLException;

}
