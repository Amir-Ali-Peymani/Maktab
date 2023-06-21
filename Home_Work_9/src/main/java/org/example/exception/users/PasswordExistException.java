package org.example.exception.users;

public class PasswordExistException extends Exception {

    public PasswordExistException(String message){
        super(message);
    }
}
