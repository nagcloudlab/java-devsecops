package com.example;

import java.util.function.Function;

public class VariableCaptureInLambda {

//    static String prefix = "Hello, "; // This is a static variable

//    String prefix = "Hello, "; // This is an instance variable

    public static void main(String[] args) {


        String prefix = "Hello, ";
//        prefix = "Hi, "; // This line will not affect the captured variable in the lambda

        Function<String, String> function = (String s) -> {
            // The lambda captures the local variable 'prefix'
            return prefix + s;
        };


        // Testing the lambda function
        String result = function.apply("World");
        System.out.println(result); // Output: Hello, World

    }
}
