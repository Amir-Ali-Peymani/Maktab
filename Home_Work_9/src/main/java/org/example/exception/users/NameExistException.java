package org.example.exception.users;

public class NameExistException extends Exception{

    public NameExistException(String message){
        super(message);
    }
}
