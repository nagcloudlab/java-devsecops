package com.example;


import java.util.function.*;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {


        Function<String, Integer> f1 = s -> s.length() + 10;
        Predicate<String> p1 = s -> s.length() > 5;
        Consumer<String> c1 = s -> System.out.println("Length of string: " + s.length());
        Supplier<String> s1 = () -> "Hello, World!";

        BiFunction<String, String, String> bf1 = (a, b) -> a + " " + b;
        BiPredicate<String, String> bp1 = (a, b) -> a.length() > b.length();
        BiConsumer<String, String> bc1 = (a, b) -> System.out.println("Concatenated: " + a + " " + b);

        UnaryOperator<String> uo1 = s -> s.toUpperCase();
        BinaryOperator<String> bo1 = (a, b) -> a + b;


        //BinaryOperator<Integer> add = (a, b) -> a + b;
        //System.out.println(add.apply(5, 10)); // Output: 15
        IntUnaryOperator increment = a -> a + 1;
        LongUnaryOperator incrementLong = a -> a + 1L;
        DoubleUnaryOperator incrementDouble = a -> a + 1.0;

        IntBinaryOperator add = (a, b) -> a + b;
        LongBinaryOperator addLong = (a, b) -> a + b;
        DoubleBinaryOperator addDouble = (a, b) -> a + b;

        IntPredicate intPredicate = a -> a > 10;
        LongPredicate longPredicate = a -> a > 10L;
        DoublePredicate doublePredicate = a -> a > 10.0;

        IntConsumer intConsumer = a -> System.out.println("Integer: " + a);
        LongConsumer longConsumer = a -> System.out.println("Long: " + a);
        DoubleConsumer doubleConsumer = a -> System.out.println("Double: " + a);

        IntSupplier intSupplier = () -> 42;
        LongSupplier longSupplier = () -> 42L;
        DoubleSupplier doubleSupplier = () -> 42.0;

        ToIntFunction<String> toIntFunction = s -> s.length();
        ToLongFunction<String> toLongFunction = s -> s.length();
        ToDoubleFunction<String> toDoubleFunction = s -> s.length() * 1.0;

        ToIntBiFunction<String, String> toIntBiFunction = (a, b) -> a.length() + b.length();
        ToLongBiFunction<String, String> toLongBiFunction = (a, b) -> a.length() + b.length();
        ToDoubleBiFunction<String, String> toDoubleBiFunction = (a, b) -> (a.length() + b.length()) * 1.0;

    }
}
