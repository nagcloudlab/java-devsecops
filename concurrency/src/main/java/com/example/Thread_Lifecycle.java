package com.example;

public class Thread_Lifecycle {
    public static void main(String[] args) {

        Runnable numberTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread Name: " + threadName + " started");
            for (int i = 0; i < 5000; i++) {
                System.out.println(threadName + " - Number: " + i);
                try {
                    Thread.sleep(1000); // TIME_WAITING
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread Name: " + threadName + " finished");
        };


        Thread thread1 = new Thread(numberTask, "Thread-1"); // NEW
        System.out.println(thread1.getState()); // NEW
        thread1.start();

        Thread thread2 = new Thread(numberTask, "Thread-2"); // NEW
        System.out.println(thread2.getState()); // NEW
        thread2.start();


    }
}
