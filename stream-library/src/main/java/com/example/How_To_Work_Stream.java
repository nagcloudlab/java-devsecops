package com.example;

import java.util.Random;
import java.util.stream.Stream;

public class How_To_Work_Stream {

    public static void main(String[] args) {

        /*
            structure of stream
                - source
                - intermediate-operation(s)
                - terminal-operation
         */

        Random random = new Random();

        // source
        Stream<Integer> stream = Stream.generate(() -> {
            return random.nextInt();
        });

        stream
                // intermediate-operation
                .peek(number -> {
                    System.out.println("Generated number: " + number);
                })
//                .limit(10)
                .filter(number -> number > 0) // filter positive numbers
                .peek(number -> {
                    System.out.println("Filtered positive number: " + number);
                })
                .limit(10) // limit to 10 elements
                // terminal-operation
                .forEach(number -> {
            System.out.println(number);
        });


    }

}
