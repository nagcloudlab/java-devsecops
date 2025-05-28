package com.example;


class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        /*
            -> read count
            -> increment count
            -> write count
            Thread-1 : read count = 0
            Thread-2 : read count = 0
            Thread-1 : increment count = 1
            Thread-2 : increment count = 1
            Thread-1 : write count = 1
            Thread-2 : write count = 1
            this is called 'race-condition'
         */
    }

    public int getCount() {
        return count;
    }
}

public class Thread_Shared_State {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };


        Thread thread1 = new Thread(incrementTask);
        thread1.start(); // Start thread 1

        Thread thread2 = new Thread(incrementTask);
        thread2.start(); // Start thread 2

        thread1.join(); // Wait for thread 1 to finish
        thread2.join(); // Wait for thread 2 to finish

        System.out.println("Counter value after thread 1: " + counter.getCount()); // Should print 1000


    }

}
