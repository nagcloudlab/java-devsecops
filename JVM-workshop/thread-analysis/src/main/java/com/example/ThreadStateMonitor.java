package com.example;

public class ThreadStateMonitor {
    public static void main(String[] args) throws InterruptedException {
        Runnable waitingTask = () -> {
            synchronized (ThreadStateMonitor.class) {
                try {
                    ThreadStateMonitor.class.wait();
                } catch (InterruptedException ignored) {
                }
            }
        };

        Runnable sleepingTask = () -> {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException ignored) {
            }
        };

        Thread t1 = new Thread(waitingTask, "WAITING-Thread");
        Thread t2 = new Thread(sleepingTask, "TIMED_WAITING-Thread");
        Thread t3 = new Thread(() -> {
        }, "TERMINATED-Thread");

        t1.start();
        t2.start();
        t3.start();
        t3.join(); // wait for it to terminate

        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            System.out.println("State of t1: " + t1.getState());
            System.out.println("State of t2: " + t2.getState());
            System.out.println("State of t3: " + t3.getState());
        }
    }
}
