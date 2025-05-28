package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class How_To_Create_Stream {
    public static void main(String[] args) throws IOException {


        // source of data : datata-elements, array,collections,file,database

        // from data elements
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .forEach(n -> System.out.println(n));

        // array
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(numbers)
                .forEach(System.out::println);

        // list collections
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream()
                .forEach(System.out::println);


        // file
        Files.lines(Path.of("/Users/nag/java-devsecops/stream-library/report.csv"))
                .forEach(System.out::println);

        // JDBC


        // generator
//        Stream.generate(() -> {
//                    return (int) (Math.random() * 100);
//                })
//                .forEach(System.out::println);

        // iterate
        Stream.iterate(1, (n) -> n + 1)
                .forEach(System.out::println);


    }
}
