package org.example.Q02;

public class DeadLock {
    public static void main(String[] args) {
        final String block01 = "Block 01";
        final String block02 = "Block 02";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (block01) {
                    System.out.println("Thread 1: locked resource 1");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (block02) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (block02) {
                    System.out.println("Thread 2: locked resource 2");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (block01) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };


        t1.start();
        t2.start();
    }
}

