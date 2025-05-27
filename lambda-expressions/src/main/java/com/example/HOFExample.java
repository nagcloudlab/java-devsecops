package com.example;

import java.util.function.Consumer;
import java.util.function.Function;

public class HOFExample {

    public static void main(String[] args) {


        Consumer englishGreeting = (name) -> {
            System.out.println("Hello, " + name + "!");
        };
        Consumer tamilGreeting = (name) -> {
            System.out.println("Vanakkam, " + name + "!");
        };

        // Higher-order function that takes a greeting function and returns a new function

        Function<Consumer<String>,Consumer<String>> aroundFunction = (greetingFunction) -> {
            return (name) -> {
                System.out.println("🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸");
                greetingFunction.accept(name);
                System.out.println("🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸");
            };
        };




        englishGreeting.accept("Alice");
        tamilGreeting.accept("Bob");

        aroundFunction.apply(tamilGreeting).accept("Charlie");


    }

}
