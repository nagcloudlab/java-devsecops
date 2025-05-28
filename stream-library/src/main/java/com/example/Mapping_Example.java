package com.example;

import java.util.List;
import java.util.stream.Stream;

public class Mapping_Example {

    public static void main(String[] args) {


        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers
                .stream()
                .map(n -> n * n) // Squaring each number
                .forEach(System.out::println); // Printing each squared number


        //----------------------------------------------

        System.out.println();

        /*

            n -> n, n*n , n*n*n

         */

        numbers
                .stream()
                .flatMap(n -> Stream.of(n, n * n, n * n * n)) // Flattening the stream to include each number, its square, and its cube
                .forEach(System.out::println);


        //-----------------------------------------------


        String[] breakFastMenu = {
                "idly,vada,poori,vada",
                "dosa,upma,poha",
                "puri,paratha"
        };

        Stream.of(breakFastMenu)
                .flatMap(line -> Stream.of(line.split(",")))
                .map(String::toUpperCase) // Converting each item to uppercase
                .distinct() // Removing duplicates
                .forEach(System.out::println);

    }

}
