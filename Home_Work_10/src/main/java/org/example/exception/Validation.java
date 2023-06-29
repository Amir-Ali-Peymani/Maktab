package org.example.exception;

public class Validation {

    public boolean isValidName(String name) {
        return name.matches("^[a-z]+$");
    }
}
