package com.example;

public class JITDemo2 {
    public static long compute(int x) {
        long result = 0;
        for (int i = 0; i < 1000; i++) {
            result += (x * i) / (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 200_000; i++) {
            compute(i); // 1000
        }
        long end = System.nanoTime();
        System.out.println("Time taken: " + ((end - start) / 1_000_000) + " ms");
    }
}
