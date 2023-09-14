package org.example.util;

public class Validation {

    public static boolean isValidEmail(String email) {
        return email.contains("@");
    }

    public static boolean isValidName(String name) {
        return name.matches("^[a-zA-Z]+$");
    }


}
