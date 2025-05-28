package com.example;

import java.util.List;

public class Sorting_Example {

    public static void main(String[] args) {


        List<String> names = List.of("John", "Alice", "Bob", "Diana");

        names
                .stream()
                .sorted((s1,s2)-> s2.compareTo(s1)) // Sorts in natural order
                .forEach(System.out::println);


    }

}
