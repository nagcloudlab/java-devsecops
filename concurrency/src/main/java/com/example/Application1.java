package com.example;


/*
 2 types tasks
 1. computation
 2. IO
 */

import java.util.Scanner;

public class Application1 {


    private static void computation() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Computation task running in thread: " + threadName);
        while (true) {
        }
        //System.out.println("Computation task completed in thread: " + threadName);
    }

    private static void io() {
        String threadName = Thread.currentThread().getName();
        System.out.println("IO task running in thread: " + threadName);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some input: ");
        String input = scanner.nextLine();
        System.out.println("You entered: " + input);
        System.out.println("IO task completed in thread: " + threadName);
    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        // step-1:
        io();
        // step-2:
        computation();


    }
}
