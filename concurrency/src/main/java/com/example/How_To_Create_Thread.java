package com.example;


//class GreetingTask implements Runnable {
//    @Override
//    public void run() {
//        String threadName = Thread.currentThread().getName();
//        System.out.println("Hello from " + threadName);
//    }
//}

import java.util.concurrent.ExecutorService;

public class How_To_Create_Thread {
    public static void main(String[] args) {

        //GreetingTask greetingTask = new GreetingTask();

        Runnable helloTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello from " + threadName);
        };
        Runnable hiTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hi from " + threadName);
        };

        // 2 ways to create threads in Java

        //--------------------------------------
        //way-1: On demand thread creation
        //--------------------------------------

//        Thread thread1 = new Thread(helloTask, "foo-thread");
//        thread1.start(); // allocate 'stack' memory for the thread and start it
//
//        Thread thread2 = new Thread(hiTask, "bar-thread");
//        thread2.start(); // allocate 'stack' memory for the thread and start it

        //--------------------------------------
        //way-2: Using thread-pool
        //--------------------------------------
        ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(2);
        executorService.submit(helloTask); // submit the task to the thread pool
        executorService.submit(hiTask); // submit the task to the thread pool


    }
}
