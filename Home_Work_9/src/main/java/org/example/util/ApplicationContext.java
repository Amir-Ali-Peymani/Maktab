package org.example.util;

import org.example.config.MyConnection;
import org.example.repository.user.UserRepository;
import org.example.repository.user.imp.UserRepositoryImpl;
import org.example.service.user.UserService;
import org.example.service.user.impl.UserServiceImpl;

import java.sql.Connection;

public class ApplicationContext {
    private static Connection connection=new MyConnection().getConnection();

    private static UserRepository userRepository;

    private static UserService userService;



    static {
        userRepository=new UserRepositoryImpl();

        userService=new UserServiceImpl(userRepository);
    }

    public static UserService getUserService(){
        return userService;
    }


    public static Connection getConnection() {
        return connection;
    }
}
