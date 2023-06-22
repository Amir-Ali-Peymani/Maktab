package org.example.exception;

public class UserIdExistException extends Exception{
    public UserIdExistException(String  id){
        super(id);
    }
}
