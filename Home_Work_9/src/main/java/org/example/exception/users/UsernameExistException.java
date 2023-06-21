package org.example.exception.users;

public class UsernameExistException extends Exception {

    public UsernameExistException(String message){
        super(message);
    }
}
