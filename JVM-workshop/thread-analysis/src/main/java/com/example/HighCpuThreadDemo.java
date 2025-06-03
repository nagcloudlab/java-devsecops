package com.example;

public class HighCpuThreadDemo {
    public static void main(String[] args) {
        Runnable cpuIntensiveTask = () -> {
            while (true) {
                // Simulating CPU burn
                Math.pow(Math.random(), Math.random());
            }
        };
        new Thread(cpuIntensiveTask, "HighCPUThread").start();
    }
}
