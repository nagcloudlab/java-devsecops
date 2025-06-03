package com.example;

public class JITDemo {

    public static void main(String[] args) {
        JITDemo demo = new JITDemo();
        for (int i = 0; i < 100_000; i++) {
            demo.compute(); // Hot method!
        }
    }

    public int compute() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i * i;
        }
        return sum;
    }
}
