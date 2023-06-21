package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.entity.User;
import org.example.exception.users.NameExistException;
import org.example.exception.users.PasswordExistException;
import org.example.exception.users.UsernameExistException;

import java.sql.SQLException;

public interface UserRepository extends BaseRepository<Integer, User> {

    boolean isExistUsername(String userName) throws SQLException, UsernameExistException;

    boolean isExistPassWord(String passWord)throws SQLException, PasswordExistException;

    boolean isExistName(String name) throws SQLException, NameExistException;
}
