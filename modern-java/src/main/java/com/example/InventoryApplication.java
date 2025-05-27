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

        // client-1 farmer
        // Req-1: filter all 'red' apples from inventory to new 'list'

        // Local Inner Class ( Named )
        class GreenApplePredicate implements Predicate {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        }
        Predicate greenApplePredicate1 = new GreenApplePredicate();

        // Local Inner Class ( Anonymous )
        Predicate greenApplePredicate2 = new Predicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("red");
            }
        };

        // Function
        // why we need function?
        // we can write concise code
        Predicate greenApplePredicate3 = apple -> apple.getColor().equals("green");
        System.out.println(
                //filterRedApples(appleInventory)
                //filterApplesByColor(appleInventory, "red")
                filterApples(appleInventory, greenApplePredicate3)
        );
        // Req-2: filter all 'green' apples from inventory to new 'list'
        System.out.println(
                //filterGreenApples(appleInventory)
                //filterApplesByColor(appleInventory, "green")
                filterApples(appleInventory, apple -> apple.getColor().equals("red"))
        );
        // Req-3: filter all apples by 'weight'
        System.out.println(
                //filterApplesByWeight(appleInventory, 1.5)
                filterApples(appleInventory, apple -> apple.getWeight() == 1.15)
        );
        // Req-4 : green applns and weight 1.5
        System.out.println(
                filterApples(appleInventory, apple -> apple.getColor().equals("red") && apple.getWeight() == 1.5)
        );



        Wheel wheel=new MRFWheel();
        wheel=new CEATWheel();


    }


    //  style of coding

    // declarative style
    // intention(what) & implementation(How) separated..
    // how ?
    // - ny primitive params
    // - by object params
    // - by function params ( recommened )

    // implementation i.e How to filter
    private static List<Apple> filterApples(List<Apple> appleInventory, Predicate predicate) {
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : appleInventory) {
            if (predicate.test(apple)) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }


    // - by primitive params
    private static List<Apple> filterApplesByColor(List<Apple> appleInventory, String color) {
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : appleInventory) {
            if (apple.getColor().equals(color)) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    private static List<Apple> filterApplesByWeight(List<Apple> appleInventory, double weight) {
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : appleInventory) {
            if (apple.getWeight() == weight) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }


    // imperative style
    // solving any problem step-by-step
    // intention(what) & implementation(How) mixed together
    private static List<Apple> filterRedApples(List<Apple> appleInventory) {
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : appleInventory) {
            if (apple.getColor().equals("red")) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    private static List<Apple> filterGreenApples(List<Apple> appleInventory) {
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : appleInventory) {
            if (apple.getColor().equals("green")) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }


}



interface  Wheel{}
class MRFWheel implements Wheel{}
class CEATWheel implements Wheel{}
