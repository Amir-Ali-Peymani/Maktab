package org.example.entity;

public class User {
    long userId;
    String name;
    String user_name;
    String email;
    String password;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public User(String name, String user_name, String email, String password) {
        this.name = name;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }
    public User(long userId, String name, String user_name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
