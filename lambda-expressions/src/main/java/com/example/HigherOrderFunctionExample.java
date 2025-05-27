package com.example;

import java.util.function.Consumer;
import java.util.function.Function;

public class HigherOrderFunctionExample {

    public static void main(String[] args) {

        Consumer<String> helloFunction = (name) -> {
            System.out.println("Hello, " + name + "!");
        };

        Consumer<String> goodbyeFunction = (name) -> {
            System.out.println("Goodbye, " + name + "!");
        };


        Function<Consumer<String>, Consumer<String>> withEmoji = f1 -> {
            return name -> {
                System.out.println("😊");
                f1.accept(name);
            };
        };

        Consumer<String> helloFunctionWithEmoji = withEmoji.apply(helloFunction);
        helloFunction.accept("Alice");
        helloFunctionWithEmoji.accept("Bob");

        Consumer<String> goodbyeFunctionWithEmoji = withEmoji.apply(goodbyeFunction);
        goodbyeFunctionWithEmoji.accept("Alice");
    }

}
