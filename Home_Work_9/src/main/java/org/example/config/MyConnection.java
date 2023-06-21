package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private String URL="jdbc:postgresql://localhost:5432/postgres";

    private String USER="postgres";

    private String PASS="1234";

    public Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
