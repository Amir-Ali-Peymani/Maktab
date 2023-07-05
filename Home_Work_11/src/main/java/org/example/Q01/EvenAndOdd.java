package org.example.Q01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenAndOdd {
    private static final Object lock = new Object();
    private static final List<Integer> numbers = new ArrayList<>();
    private static boolean isOddTurn = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int input = scanner.nextInt();

        Thread evenThread = new Thread(() -> generateEvenNumbers(input));
        Thread oddThread = new Thread(() -> generateOddNumbers(input));

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List of all numbers: " + numbers);
    }

    private static void generateEvenNumbers(int input) {
        for (int i = 0; i <= input; i += 2) {
            synchronized (lock) {
                while (!isOddTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                numbers.add(i);
                isOddTurn = false;
                lock.notify();
            }
        }
    }

    private static void generateOddNumbers(int input) {
        for (int i = 1; i <= input; i += 2) {
            synchronized (lock) {
                while (isOddTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                numbers.add(i);
                isOddTurn = true;
                lock.notify();
            }
        }
    }
}

