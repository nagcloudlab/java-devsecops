package com.example;

import com.example.model.Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryApplication {

    public static void main(String[] args) {

//        List<Apple> appleInventory=new ArrayList<>();
//        appleInventory.add(new Apple("red", 1.2));
//        appleInventory.add(new Apple("green", 1.5));
//        appleInventory.add(new Apple("yellow", 1.0));
//        appleInventory.add(new Apple("red", 1.3));
//        appleInventory= Collections.unmodifiableList(appleInventory);
//        appleInventory.add(new Apple("red", 1.4)); // This will throw UnsupportedOperationException


        List<Apple> appleInventory = List.of(
                new Apple("red", 1.2),
                new Apple("green", 1.5),
                new Apple("yellow", 1.0),
                new Apple("red", 1.3)
        );

        // client=: farmer
        // Re1: filter all 'red' apples from inventory to new 'list'

    }

}
