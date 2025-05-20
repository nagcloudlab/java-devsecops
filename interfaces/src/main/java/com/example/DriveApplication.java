package com.example;

import com.example.car.Car;
import com.example.wheel.CEATWheel;
import com.example.wheel.MRFWheel;
import com.example.wheel.Wheel;

public class DriveApplication {
    public static void main(String[] args) {

        Wheel mrfWheel = new MRFWheel();
        Car car = new Car(mrfWheel);
        System.out.println();
        car.move();
        System.out.println();
        car.move();


        Wheel ceatWheel = new CEATWheel();
        car.setWheel(ceatWheel);

        System.out.println();
        car.move();
        System.out.println();
        car.move();


    }
}
