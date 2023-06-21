package org.example.entity;

import org.example.base.entity.BaseEntity;

public class User extends BaseEntity<Integer> {

    private String name;

    private String userName;

    private String passWord;

    public User(String name, String userName, String passWord) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(Integer integer, String name, String userName, String passWord) {
        super(integer);
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", id=" + id +
                '}';
    }
}
