package org.example.exception;

import java.util.Scanner;

public class CustomException {
    private final Scanner input;
    private final Validation validation;

    public CustomException() {
        input = new Scanner(System.in);
        validation = new Validation();
    }
    public String giveInput(String name) {
        String input;
        while (true){
            System.out.print(name + ": ");
            input = this.input.nextLine();
            if(validation.isValidName(input))
                return input;
        }
    }
}
