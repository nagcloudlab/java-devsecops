package com.example;

public class ClassLoaderExample {

    static int x;

    static {
        // initialization block
        //....
        System.out.println("Static block executed");
        x = 10;
    }

    public static void main(String[] args) {

        ClassLoader loader = ClassLoaderExample.class.getClassLoader();
        System.out.println(loader.getName());
        System.out.println(loader.getParent().getName());
        System.out.println(loader.getParent().getParent());


    }
}
