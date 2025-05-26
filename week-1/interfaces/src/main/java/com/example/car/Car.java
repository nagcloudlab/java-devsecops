package com.example.car;

//import com.example.wheel.MRFWheel;

import com.example.wheel.MRFWheel;
import com.example.wheel.Wheel;

public class Car {

    //    private MRFWheel wheel; // variable to hold the wheel object
    private Wheel wheel; // mandatory dependency


    // Constructor
    public Car(Wheel wheel) {
//        wheel = new MRFWheel(); // create a new instance of MRFWheel
        this.wheel = wheel; // assign the passed wheel object to the class variable
        System.out.println("Car created ");
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void move() {
        //wheel = new MRFWheel(); // create a new instance of MRFWheel
        int rpm=wheel.rotate(100);
        System.out.println("Car is moving with RPM: " + rpm);
    }

}
