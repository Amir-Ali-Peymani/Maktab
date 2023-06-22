package org.example.repository.cart;

import org.example.exception.UserIdExistException;

import java.sql.SQLException;

public interface CartRepository {

    boolean doesUserIdExist(String id) throws SQLException, UserIdExistException;
}
