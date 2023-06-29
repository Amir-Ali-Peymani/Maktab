package org.example.question01;

import java.util.HashMap;
import java.util.Scanner;

public class Question1_B {
    public static void start() {
        HashMap <Character,  Integer> input01 = new HashMap<>();
        HashMap <Character,  Integer> input02 = new HashMap<>();
        String[] input = getInput();
        String input1 = input[0];
        String input2 = input[1];
        for (int i = 0; i < input1.length(); i++) {
            input01.put(input1.charAt(i), input01.getOrDefault(input1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < input2.length(); i++) {
            input02.put(input2.charAt(i), input02.getOrDefault(input2.charAt(i), 0) + 1);
        }
        checking(input01, input02);

    }

    private static void checking(HashMap<Character, Integer> input1, HashMap<Character, Integer> input02) {
        if (input1.size()!= input02.size()) {
            System.out.println("FAIL");
            return;
        } else {
            for (char key : input1.keySet()) {
                if (!input02.containsKey(key)) {
                    System.out.println("FAIL");
                } else {
                    System.out.println("PASS");
                    return;
                }
            }
        }
    }

    private static String[] getInput() {
        Scanner scanner = new Scanner(System.in);
        String[] input01 = new String[2];
        System.out.print("value 1: ");
        String input1 = scanner.nextLine();
        System.out.print("value 2: ");
        String input2 = scanner.nextLine();
        input01[0] = input1;
        input01[1] = input2;
        return input01;
    }
}

