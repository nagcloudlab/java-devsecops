package com.example;


import java.util.Vector;

class Building {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public void room1() {
        synchronized (lock1) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is in room 1");
            try {
                Thread.sleep(1000); // Simulating some work in room 1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " is leaving room 1");
        }
    }

    public void room2() {
        synchronized (lock2) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is in room 2");
            try {
                Thread.sleep(1000); // Simulating some work in room 1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " is leaving room 2");
        }
    }
}


public class How_To_Use_Synchronized_Keyword {
    public static void main(String[] args) {

        Building building1 = new Building();
        Building building2 = new Building();

        Runnable room1Task1 = () -> {
            building1.room1();
        };
        Runnable room1Task2 = () -> {
            building2.room2();
        };

        Thread thread1 = new Thread(room1Task1, "A");
        Thread thread2 = new Thread(room1Task1, "B");
        Thread thread3 = new Thread(room1Task2, "C");

        thread1.start();
        thread2.start();
        thread3.start();

        Vector<Integer> vector = new Vector<>();

    }
}
