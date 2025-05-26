package com.example.wheel;

public class MRFWheel implements Wheel {

    // Constructor
    public MRFWheel() {
        System.out.println("MRF Wheel is created");
    }

    public int rotate(int speed) {
        System.out.println("MRF Wheel is rotating");
        int rpm = speed * 1000 / (int) (Math.PI * 0.7);
        System.out.println("RPM: " + rpm);
        return rpm;
    }
}
