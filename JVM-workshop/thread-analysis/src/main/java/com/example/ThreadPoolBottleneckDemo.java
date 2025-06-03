package com.example;

import java.util.concurrent.*;
import java.util.concurrent.BlockingQueue;

public class ThreadPoolBottleneckDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(5);

        Runnable blockingTask = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " started");
                Thread.sleep(10000); // Simulate blocking
                System.out.println(Thread.currentThread().getName() + " ended");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        for (int i = 0; i < 10; i++) {
            pool.submit(blockingTask);
        }

        pool.shutdown();
    }
}
