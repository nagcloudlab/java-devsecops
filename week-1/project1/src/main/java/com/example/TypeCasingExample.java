package com.example;


abstract class V {
}

class Bike extends V {
    int bikeField;
}

class Car extends V {
    int carField;
}

public class TypeCasingExample {

    public static void main(String[] args) {

        Bike bike = new Bike();
        Car car = new Car();

        doMechanic(bike);
        doMechanic(car);

    }

    static void doMechanic(V vehicle) {
        //...
        if (vehicle instanceof Bike) {
            Bike bike = (Bike) vehicle;
            System.out.println(bike.bikeField);
        }
    }

}
