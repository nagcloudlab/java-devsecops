package com.example;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {

        Queue<String> queue = new java.util.LinkedList<>();
        // Adding elements to the queue
        queue.offer("Element 1");
        queue.offer("Element 2");
        queue.offer("Element 3");
        // Displaying the queue

        while (!queue.isEmpty()) {
            System.out.println("Queue Element: " + queue.poll());
        }


        Queue<Integer> intQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1); // Natural ordering for integers
            }
        });
        // Adding elements to the priority queue
        intQueue.offer(10);
        intQueue.offer(20);
        intQueue.offer(15);
        // Displaying the priority queue elements in natural order
        while (!intQueue.isEmpty()) {
            System.out.println("Priority Queue Element: " + intQueue.poll());
        }

    }
}
