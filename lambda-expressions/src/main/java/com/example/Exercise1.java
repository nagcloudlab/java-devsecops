package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>();
        menu.add("veg");
        menu.add("veg");
        menu.add("non-veg");
        menu.add("veg");
        menu.add("non-veg");

//        for (String item : menu) {
//            System.out.println(item);
//        }

        // Imperative style
//        Iterator<String> iterator = menu.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if (item.equals("non-veg"))
//                iterator.remove();
//        }
//
//        System.out.println("After removing non-veg items:");
//        System.out.println(menu);

        // Declarative style

//        menu.removeIf(item -> item.equals("non-veg"));
//        System.out.println("After removing non-veg items:");
//        System.out.println(menu);


        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // do case conversion
        names.replaceAll(name -> name.toUpperCase());


    }

}
