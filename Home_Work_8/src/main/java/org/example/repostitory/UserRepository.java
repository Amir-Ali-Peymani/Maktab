package org.example.repostitory;

import org.example.config.MyConnection;
import org.example.entity.User;

import java.sql.*;

public class UserRepository {
    public void saveUser(User user) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "insert into users( name, username, email, password) values (?,?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUser_name());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.executeUpdate();
    }
    public User loadUser(int Id) throws SQLException {
        String name = "";
        String userName = "";
        String email = "";
        String password = "";
        Connection connection = MyConnection.getConnection();
        String sql = "SELECT * FROM  users where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            name = resultSet.getString("name");
            userName = resultSet.getString("username");
            email = resultSet.getString("email");
            password = resultSet.getString("password");
        }
        User users = new User(name, userName, email, password);
        resultSet.close();
        preparedStatement.close();
        return users;
    }
    public void updateUser(int id, int input, String input1) throws SQLException {
        Connection connection = MyConnection.getConnection();
        if (input == 1) {
            String sql = "UPDATE users set name = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        if (input == 2) {
            String sql = "UPDATE users set username = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        if (input == 3) {
            String sql = "UPDATE users set email = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
        if (input == 4) {
            String sql = "UPDATE users set password = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, input1);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }
    public void userDelete(int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
