package org.example.service;

import org.example.entity.User;
import org.example.repostitory.UserRepository;

import java.sql.SQLException;

public class UserService {
    UserRepository userRepository = new UserRepository();
    public void register(String name, String user_name, String email, String password) throws SQLException {
        User user = new User(name, user_name, email, password);
        userRepository.saveUser(user);
    }
    public void load(int id) throws SQLException {
        System.out.println("------------------------------------------------------------");
        System.out.println("The name: "+userRepository.loadUser(id).getName());
        System.out.println("The user_name: "+userRepository.loadUser(id).getUser_name());
        System.out.println("The email: "+userRepository.loadUser(id).getEmail());
        System.out.println("The password: "+userRepository.loadUser(id).getPassword());
        System.out.println("------------------------------------------------------------");
    }
    public void update(int id1, int input0, String input1) throws SQLException {
        userRepository.updateUser(id1, input0, input1);
    }
    public void delete(int id0) throws SQLException {
        userRepository.userDelete(id0);
    }
}
