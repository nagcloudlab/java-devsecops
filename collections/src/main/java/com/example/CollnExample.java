package com.example;

import java.util.*;

public class CollnExample {

    public static void main(String[] args) {

        //---------------------------------
        // List Colln
        //---------------------------------

        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("C");
        list1.add("B");
        list1.add("E");
        list1.add("D");
        list1.add("D");

//        System.out.println("List1: " + list1);
//        System.out.println("List1 size: " + list1.size());
//        for (String s : list1) {
//            System.out.println("List1 item: " + s);
//        }


        //---------------------------------
        // Set Colln
        //---------------------------------

        //Set<String> set1 = new TreeSet<>();
        //Set<String> set1 = new HashSet<>();
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("A");
        set1.add("C");
        set1.add("B");
        set1.add("E");
        set1.add("P");
        set1.add("D");
        set1.add("D"); // Duplicate, will not be added
        System.out.println("Set1: " + set1);
        System.out.println("Set1 size: " + set1.size());
        for (String s : set1) {
            System.out.println("Set1 item: " + s);
        }


        //---------------------------------
        // Map Colln
        //---------------------------------

        //Map<String, String> map1 = new TreeMap<>();
        //Map<String, String> map1 = new HashMap<>();
        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("A", "Apple");
        map1.put("C", "Cherry");
        map1.put("B", "Banana");
        map1.put("C", "Carrot");
        map1.put("P", "Pine");
        map1.put("E", "Eggplant");

        System.out.println("Map1: " + map1);
        System.out.println("Map1 size: " + map1.size());
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println("Map1 key: " + entry.getKey() + ", value: " + entry.getValue());
        }


    }

}
