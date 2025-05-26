package com.example;

import com.example.model.Car;
import com.example.model.Owner;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapExample {
    public static void main(String[] args) {


        Owner owner1 = new Owner("Riya", "chennai");
        Owner owner2 = new Owner("Diya", "hyderabad");

        Car car1 = new Car("BMW", "X5", 2020);
        Car car2 = new Car("Audi", "Q7", 2021);

        Map<Owner, Car> carMap = new HashMap<>();
        carMap.put(owner1, car1);
        carMap.put(owner2, car2);

        System.out.println("...");

        Owner key = new Owner("Riya", null);
        Car car = carMap.get(key);
        if (car != null) {
            System.out.println("Car found: " + car.getMake() + " " + car.getModel() + " " + car.getYear());
        } else {
            System.out.println("Car not found for owner: " + key.getName());
        }


    }
}
