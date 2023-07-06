package org.example.Q03;

public class ThreadRunning implements Runnable{
    private static final Object lock = new Object();

    public void run() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+ " is running");
    }
}
