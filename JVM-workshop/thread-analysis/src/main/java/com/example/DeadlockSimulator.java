package com.example;

public class DeadlockSimulator {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void createDeadlock() {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread-1 acquired lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
                synchronized (lock2) {
                    System.out.println("Thread-1 acquired lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread-2 acquired lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
                synchronized (lock1) {
                    System.out.println("Thread-2 acquired lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        System.out.println("Starting deadlock simulation...");
        createDeadlock();

        // Wait for threads to finish
        try {
            Thread.sleep(500); // Adjust as necessary to observe deadlock
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Deadlock simulation complete.");
    }

}
