package com.example;

import java.util.ArrayList;
import java.util.List;

class FoodLibrary {
    public boolean isVegetarian(String foodItem) {
        return foodItem
                .equalsIgnoreCase("Salad") || foodItem.equalsIgnoreCase("Vegetable Stir Fry") || foodItem.equalsIgnoreCase("Fruit Salad");
    }

    public boolean isNonVegetarian(String foodItem) {
        return !isVegetarian(foodItem);
    }
}

public class MethodReference {
    public static void main(String[] args) {


        List<String> foodItems = new ArrayList<>();
        foodItems.add("Pizza");
        foodItems.add("Burger");
        foodItems.add("Pasta");
        foodItems.add("Salad");
        foodItems.add("Chicken Wings");
        foodItems.add("Fish and Chips");
        foodItems.add("Vegetable Stir Fry");
        foodItems.add("Fruit Salad");


        //foodItems.removeIf(item -> FoodLibrary.isNonVegetarian(item));
        FoodLibrary foodLibrary = new FoodLibrary();
        foodItems.removeIf(foodLibrary::isNonVegetarian);

        System.out.println("Vegetarian Food Items: " + foodItems);

    }
}
