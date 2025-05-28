package com.example;

import com.example.model.Dish;

import java.util.List;

public class Filtering_Example {

    public static void main(String[] args) {


        // filtering
        //------------------
        // content -> filter
        // count -> skip, limit
        // unique -> distinct

        // content
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 6, 7, 7, 8, 9, 10);
        numbers.stream()
                .filter(n -> n % 2 == 0) // filter even numbers
                .forEach(System.out::println); // print each even number

        System.out.println();
        // count
        numbers.stream()
                .skip(3)
                .limit(5) // limit to first 5 elements
                .forEach(System.out::println); // print each element
        System.out.println();
        // unique
        numbers.stream()
                .distinct() // remove duplicates
                .forEach(System.out::println); // print each unique number


        // JDK 9

        // filtering
        //------------------

        // takewhile
        // dropwhile

        System.out.println();

        List<Integer> sortedNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // take numbers while they are less than 5
        sortedNumbers.stream()
                .peek(n -> System.out.println("before filter " + n)) // print each element before filtering
                .dropWhile(n -> n < 5)
                .forEach(System.out::println); // print each element

    }

}
