package org.example.Q2;

import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Class02 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("marry", "Jhon", "Kail", "amiral", "cat");

        Map<Integer, List<String>> wordLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(wordLength);
    }
}
