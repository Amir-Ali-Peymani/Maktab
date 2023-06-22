package org.example.service.user;


import org.example.base.service.BaseService;
import org.example.entity.User;
import org.example.exception.PasswordExistException;

import java.sql.SQLException;

public interface UserService extends BaseService<Integer, User> {


    boolean isExistUsername(String userName) throws Exception;

    boolean isExistPassWord(String passWord) throws SQLException, PasswordExistException;

    User checkCredentialInfoForLogin(String userName, String passWord) throws Exception;
}
