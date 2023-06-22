package org.example.repository.user;

import org.example.base.repository.BaseRepository;
import org.example.entity.User;
import org.example.exception.PasswordExistException;
import org.example.exception.UsernameExistException;

import java.sql.SQLException;

public interface UserRepository extends BaseRepository<Integer, User> {

    boolean isExistUsername(String userName) throws SQLException, UsernameExistException;

    boolean isExistPassWord(String passWord)throws SQLException, PasswordExistException;


    User findUserByUsername(String userName) throws SQLException;
}
