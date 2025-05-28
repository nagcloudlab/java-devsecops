package com.example;

import com.example.model.Dish;
import com.example.model.DishType;

import java.util.List;

public class Terminal_Operation_Example {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;


        // Void terminal operation example
        menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .forEach(dish -> System.out.println("High calorie dish: " + dish.getName()));


        //---------------------------------------
        // Collecting terminal operation example
        //----------------------------------------

        // To List

        System.out.println();
        List<Dish> highCalorieDishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(java.util.stream.Collectors.toList());

        System.out.println("High calorie dishes: " + highCalorieDishes);


        // To Set
        System.out.println();
        java.util.Set<Dish> highCalorieDishSet = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(java.util.stream.Collectors.toSet());
        System.out.println("High calorie dish set: " + highCalorieDishSet);

        // To Map
        System.out.println();
        java.util.Map<String, Integer> highCalorieDishMap = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(java.util.stream.Collectors.toMap(Dish::getName, Dish::getCalories));
        System.out.println("High calorie dish map: " + highCalorieDishMap);


        // Joining strings
        System.out.println();
        String highCalorieDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .collect(java.util.stream.Collectors.joining(", "));
        System.out.println("High calorie dish names: " + highCalorieDishNames);


        // Summing integers
        System.out.println();
        int totalCalories = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(java.util.stream.Collectors.summingInt(Dish::getCalories));
        System.out.println("Total calories of high calorie dishes: " + totalCalories);

        // Averaging integers
        System.out.println();
        double averageCalories = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(java.util.stream.Collectors.averagingInt(Dish::getCalories));

        System.out.println("Average calories of high calorie dishes: " + averageCalories);

        // Counting
        System.out.println();
        long countHighCalorieDishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .collect(java.util.stream.Collectors.counting());

        System.out.println("Count of high calorie dishes: " + countHighCalorieDishes);

        // Grouping by a property
        System.out.println();
        java.util.Map<DishType, List<Dish>> dishesByType = menu.stream()
                .collect(java.util.stream.Collectors.groupingBy(Dish::getType));
        System.out.println("Dishes grouped by type: " + dishesByType);


        // Partitioning by a predicate
        // separate vegetarian and non-vegetarian dishes
        System.out.println();
        java.util.Map<Boolean, List<Dish>> partitionedDishes = menu.stream()
                .collect(java.util.stream.Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println("Dishes partitioned by vegetarian status: " + partitionedDishes);

        // Reducing to a single value
        System.out.println();
        int totalCaloriesReduced = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        System.out.println("Total calories of high calorie dishes (reduced): " + totalCaloriesReduced);


        // Finding the maximum calorie dish
        System.out.println();
        Dish maxCalorieDish = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .max(java.util.Comparator.comparingInt(Dish::getCalories))
                .orElse(null);
        System.out.println("Max calorie dish: " + (maxCalorieDish != null ? maxCalorieDish.getName() : "None"));


        // anyMatch, allMatch, noneMatch -> boolean terminal operations

        // is there any vegetarian dish?
        System.out.println();
        boolean hasVegetarianDish = menu.stream()
                .noneMatch(Dish::isVegetarian);
        System.out.println("Is there any vegetarian dish? " + hasVegetarianDish);


        // are all dishes vegetarian?
        System.out.println();
        boolean allDishesVegetarian = menu.stream()
                .allMatch(Dish::isVegetarian);

        System.out.println("Are all dishes vegetarian? " + allDishesVegetarian);


    }

}
