package com.example.wheel;

public class CEATWheel implements Wheel {

    public int rotate(int speed) {
        System.out.println("CEAT Wheel is rotating");
        int rpm = speed * 1000 / (int) (Math.PI * 0.9);
        System.out.println("RPM: " + rpm);
        return rpm;
    }

}
