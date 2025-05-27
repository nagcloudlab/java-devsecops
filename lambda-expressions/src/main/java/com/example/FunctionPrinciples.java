package com.example;


import java.util.function.Predicate;

/**
 * First Class Functions
 * <p>
 * <p>
 * - A function can be stored in a variable or value
 * - A parameter of a function can be a function
 * - The return value of a function can be a function
 */

public class FunctionPrinciples {

    private static Predicate<Integer> and(Predicate<Integer> p1, Predicate<Integer> p2) {
        return (Integer i) -> p1.test(i) && p2.test(i);
    }

    public static void main(String[] args) {

        int v=12;

        // First Class Functions
        // A function can be stored in a variable or value
        Predicate<Integer> isMin = (Integer i) -> i < 10;
        Predicate<Integer> isMax = (Integer i) -> i > 100;
        Predicate<Integer> isMinAndIsMax = and(isMin, isMax);

        System.out.println(isMinAndIsMax.test(5));   // false
    }
}
