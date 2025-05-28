package com.example;

import java.util.List;
import java.util.stream.Stream;

public class Common_Mistake_With_Stream {
    public static void main(String[] args) {


        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        Stream<String> s1 = names.stream()
                .filter(name -> name.startsWith("A"));
        s1.forEach(System.out::println);

        s1.forEach(System.out::println); // This will throw IllegalStateException

    }
}
