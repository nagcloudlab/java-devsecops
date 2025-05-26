package com.example;

import com.example.model.Car;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {

        Car car1 = new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Toyota", "Corolla", 2020);

        // display the hash codes
        System.out.println("Hash code of car1: " + car1.hashCode());
        System.out.println("Hash code of car2: " + car2.hashCode());

        // display equality
        System.out.println("car1 equals car2: " + car1.equals(car2));

        Set<Car> cartSet = new HashSet<>(10, 0.75f);
        cartSet.add(car1);
        cartSet.add(car2);

        System.out.println("Size of HashSet: " + cartSet.size());


    }

}
