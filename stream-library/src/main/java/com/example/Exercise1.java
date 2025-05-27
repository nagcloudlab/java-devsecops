package com.example;

import com.example.model.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


// data processing code
// - filtering
// - mapping aka transforming
// - aggregation
// - grouping
// - sorting
// - partitioning
// - min, max, sum, average
// - allMatch, anyMatch, noneMatch
// - findFirst, findAny
// - collecting to a list, set, map, etc.


public class Exercise1 {

    public static void main(String[] args) {


        List<Dish> menu = Dish.menu; // immutable list of dishes

        // - get low cal ( < 400 ) dish's names sorted by cal into new List
        // output : season fruit, rice


        System.out.println(
                //getLowCalDishNamesSortedByCalV1(menu)
                getLowCalDishNamesSortedByCalV2(menu)
        );

    }

    // data processing pipeline by stream API
    private static List<String> getLowCalDishNamesSortedByCalV2(List<Dish> menu) {
        return menu
                .stream()
                .filter(dish -> dish.getCalories() < 400) // step-1 : filter dish if calories < 400
                .sorted(Comparator.comparing(Dish::getCalories)) // step-2 : sort low cal dishes by calories
                .map(Dish::getName)
                .collect(Collectors.toList());
    }


    private static List<String> getLowCalDishNamesSortedByCalV1(List<Dish> menu) {
        // step-1 : filter dish if calories < 400
        List<Dish> lowCalDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCalDishes.add(dish);
            }
        }
        // step-2 : sort low cal dishes by calories
        Comparator<Dish> calComparator = new Comparator<>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        };
        lowCalDishes.sort(calComparator);
        // step-3 : map low cal dishes to names
        List<String> lowCalDishNames = new ArrayList<>();
        for (Dish dish : lowCalDishes) {
            lowCalDishNames.add(dish.getName());
        }
        return lowCalDishNames;

    }

}
