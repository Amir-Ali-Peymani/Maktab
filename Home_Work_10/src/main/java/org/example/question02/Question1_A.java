package org.example.question02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Question1_A {
    public static void main(String[] args) {
        TreeSet<Character> set1 = new TreeSet<>();
        TreeSet<Character> set2 = new TreeSet<>();
        partA(set1,  set2);
        partB(set1,  set2);
        partC(set1,  set2);
    }
    private static void partA(TreeSet<Character> set1, TreeSet<Character> set2) {
        Random random = new Random();
        List<Character> list = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            list.add(c);
        }
        while (set1.size() < 10) {
            int randomIndex = random.nextInt(list.size());
            char randomChar = list.get(randomIndex);
            set1.add(randomChar);
        }


        while (set2.size() < 10) {
            int randomIndex = random.nextInt(list.size());
            char randomChar = list.get(randomIndex);
            set2.add(randomChar);
        }

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
    }

    private static void partB(TreeSet<Character> set01,  TreeSet<Character> set02) {
        TreeSet<Character> sum = new TreeSet<>();
        sum.addAll(set01);
        sum.addAll(set02);
        System.out.println("Sum: " + sum);
    }

    private static void partC(TreeSet<Character> set01,  TreeSet<Character> set02) {
        TreeSet<Character> common = new TreeSet<>(set01);
        common.retainAll(set02);
        System.out.println("Common: " + common);
    }
}