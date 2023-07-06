package org.example.Q03;


public class Starvation {

    public static void main(String[] args) {
        ThreadRunning threadRunning =  new ThreadRunning();

        Thread thread01 = new Thread(threadRunning);
        thread01.setName("thread01");
        thread01.setPriority(Thread.MIN_PRIORITY);

        Thread thread02 = new Thread(threadRunning);
        thread02.setName("thread02");
        thread02.setPriority(Thread.MAX_PRIORITY);


        thread01.start();
        thread02.start();

    }
}

