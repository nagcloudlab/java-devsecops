package com.example;

import java.util.ArrayList;
import java.util.List;

public class Managing_Strings {

    static final int COUNT = 10_000_000;

    public static void main(String[] args) throws InterruptedException {

        String s1 = "npci"; // string literal
        String s2 = "npci";

        System.out.println(s1 == s2);

        String s3 = new String("npci"); // heap objects
        String s4 = new String("npci");

        System.out.println(s3 == s4);

        List<String> list = new ArrayList<>(COUNT);
        String base = "INDIA";

        for (int i = 0; i < COUNT; i++) {
            // Toggle between with/without intern
//            String s = new String(base); // always creates a new object
            String s = new String(base).intern(); // enable this for intern test

            list.add(s);
        }

        System.out.println("Strings created: " + list.size());

        // Keep JVM alive for inspection
        Thread.sleep(5 * 60 * 1000);
    }
}





