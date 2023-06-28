package org.example.question01;

import java.util.HashMap;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input: ");
        String string = scanner.nextLine();
        generate2("", string);
    }

    private static void generate2(String nothing, String string) {
        if (string.isEmpty()) {
            System.out.println(nothing);
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                String newPrefix = nothing + c;
                generate2(newPrefix, string.substring(0, string.indexOf(c)) +
                        string.substring(string.indexOf(c) + 1));
                map.put(c, count);
            }
        }
    }
}
