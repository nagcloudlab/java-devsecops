package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from project2!");
        int a = 12;
        int b = 8;
        com.example.arith.Calculator calculator = new com.example.arith.Calculator();
        System.out.println("Addition: " + calculator.add(a, b));
    }
}