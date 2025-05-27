package com.example;


import java.util.ArrayList;
import java.util.List;

@FunctionalInterface //  ( SAM - Single Abstract Method )
interface Condition {
    boolean test(Integer i);
}

class MathLib {
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evens.add(number);
            }
        }
        return evens;
    }

    public static List<Integer> filterOddNumbers(List<Integer> numbers) {
        List<Integer> odds = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                odds.add(number);
            }
        }
        return odds;
    }


    public static List<Integer> filterNumbers(List<Integer> numbers, Condition func) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (func.test(number)) {
                result.add(number);
            }
        }
        return result;
    }


}

public class HowToCreateFunction {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = MathLib.filterEvenNumbers(numbers);
        System.out.println("Even numbers: " + evenNumbers);

        List<Integer> oddNumbers = MathLib.filterOddNumbers(numbers);
        System.out.println("Odd numbers: " + oddNumbers);

        //-------------------------------------------------------------

        Condition evenCondition = i -> i % 2 == 0;
        evenNumbers = MathLib.filterNumbers(numbers, evenCondition);
        System.out.println("Even numbers using lambda: " + evenNumbers);

        oddNumbers = MathLib.filterNumbers(numbers, i -> i % 2 != 0);
        System.out.println("Odd numbers using lambda: " + oddNumbers);

        List<Integer> greaterThanFive = MathLib.filterNumbers(numbers, i -> i > 5);
        System.out.println("Numbers greater than five: " + greaterThanFive);

        //-------------------------------------------------------------


    }
}
