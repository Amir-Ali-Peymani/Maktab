package org.example.Q2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Class01 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("marry", "Kail", "amiral", "cat");

        Map<Integer, List<String>> wordLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        words = wordLength.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(words);


    }
}
