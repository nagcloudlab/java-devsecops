package com.example;


/*

    Type Casting in Java

    Type casting is the process of converting a variable from one data type
    to another.

    // implicit type casting ==> done by JRE
    byte > short > int > long > float > double
    // explicit type casting ==> done by programmer



 */

public class TypeCastingExample {
    public static void main(String[] args) {

        int n1 = 6;
        int n2 = 4;
        float n3 = (float) n1 / n2;
        System.out.println("n3: " + n3); // Output: n3: 1.5


        int i = 456;
        byte b = (byte) i; // explicit type casting
        System.out.println(b);


        for (int j = 0; j < 128; j++) {
            char c = (char) j; // explicit type casting
            System.out.println("j: " + j + " c: " + c);
        }

    }
}
