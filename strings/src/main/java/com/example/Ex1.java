package com.example;


import java.util.ArrayList;
import java.util.List;

/**
 * How to create Strings Object ?
 * <p>
 * 2 ways
 * <p>
 * 1. String literal  ==> ""
 * 2. String Object   ==> new String()
 */

public class Ex1 {


    static final int COUNT = 10_000_000;

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>(COUNT);

        String base = "INDIA";

        for (int i = 0; i < COUNT; i++) {
            // Toggle between with/without intern
            //String s = new String(base); // always creates a new object
             String s = new String(base).intern(); // enable this for intern test
            list.add(s);
        }

        System.out.println("Strings created: " + list.size());

        // Keep JVM alive for inspection
        Thread.sleep(5 * 60 * 1000);


    }

}
