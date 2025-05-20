package com.example;

public class PrimitiveTypesExample {

    public static void main(String[] args) {

        // Primitive types in Java

        // 1. Integer types
        // byte - 8 bits -> -128 to 127
        byte byteValue = 127;
        // short - 16 bits -> -32,768 to 32,767
        short shortValue = 32767;
        // int - 32 bits -> -2,147,483,648 to 2,147,483,647
        int intValue = 2147483647;
        // long - 64 bits -> -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        long longValue = 9223372036854775807L;

        // 2. Floating-point types
        // float - 32 bits -> 1.4E-45 to 3.4028235E38
        float floatValue = 3.4028235E38f;
        // double - 64 bits -> 4.9E-324 to 1.7976931348623157E308
        double doubleValue = 1.7976931348623157E308;

        // 3. Character type
        // char - 16 bits -> 0 to 65,535 (Unicode characters)
        char charValue = 'A'; // Unicode value for 'A' is 65
        char unicodeCharValue = '\u0041'; // Unicode representation of 'A'
        char inrSymbol = '\u8377'; // Unicode representation of Indian Rupee symbol

        // 4. Boolean type
        // boolean - 1 bit -> true or false
        boolean booleanValue = true;
        boolean isJavaFun = true;


        //-------------------------------

        int a = 10; // decimal
        System.out.println(a); // 10
        int b = 012; // octal (base 8)
        System.out.println(b); // 10
        int c = 0xA; // hexadecimal (base 16)
        System.out.println(c); // 10
        int d = 0b1010; // binary (base 2)
        System.out.println(d); // 10

        //----------------------------------

        long cred_card = 1234_5678_9012_3456L; // long type for credit card number
        long salary = 1_000_000L; // long type for salary

        //----------------------------------



    }

}
