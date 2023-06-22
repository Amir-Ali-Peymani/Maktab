package org.example.exception;

public class PasswordExistException extends Exception {

    public PasswordExistException(String message){
        super(message);
    }
}
