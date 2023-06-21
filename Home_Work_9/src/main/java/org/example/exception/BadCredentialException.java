package org.example.exception;

public class BadCredentialException extends Exception {

    public BadCredentialException(String badCredential){
        super(badCredential);
    }
}
