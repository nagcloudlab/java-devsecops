package com.example;


/*
    Person
        - Car  ( optional )
            - Insurance ( optional )
 */

import java.util.Optional;

class Insurance {
    String name;
}

class Car {
    String model;
    //Insurance insurance = null;  // optional
    Optional<Insurance> insurance = Optional.empty();
}

class Person {
    String name;
    //Car car = null;
    Optional<Car> car = Optional.empty();
}

public class Example {

    public static void main(String[] args) {

        // scenario-1: a person has car has insurance
        Insurance insurance = new Insurance();
        insurance.name = "lic";

        Car car = new Car();
        car.model = "model1";
        car.insurance = Optional.of(insurance);

        Person person = new Person();
        person.name = "P1";
        person.car = Optional.of(car);


        String personCarInsuranceName = getInsuranceName(person);
        System.out.println(personCarInsuranceName);

        //---------------------------------------------------
        // scenario-1: a person has car has  no insurance
        //
//
//        Car car2 = new Car();
//        car2.model = "model1";
//
//        Person person2 = new Person();
//        person2.name = "P1";
//        person2.car = car2;
//
//        String person2CarInsuranceName = getInsuranceName(person2);
//        System.out.println(person2CarInsuranceName);


    }

    private static String getInsuranceName(Person person) {
        return
                person.car
                        .flatMap(car -> car.insurance)
                        .map(insurance -> insurance.name)
                        .get();
    }

}
