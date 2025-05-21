package com.example;

interface Food {
}

class VegFood implements Food {
}

class NonVegFood implements Food {
}


class FoodFactory {
    public static Food createFood(String foodType) {
        if (foodType.equals("veg")) {
            return new VegFood();
        } else if (foodType.equals("non-veg")) {
            return new NonVegFood();
        } else {
            throw new IllegalArgumentException("Invalid food type");
        }
    }
}


public class FactoryExample {
    public static void main(String[] args) {

        //---------------------------------------
        // module-1
        //---------------------------------------

        String foodType = "veg"; // | "non-veg"
        Food food = FoodFactory.createFood(foodType);

        if (food instanceof VegFood) {
            System.out.println("Veg food created");
        } else if (food instanceof NonVegFood) {
            System.out.println("Non-veg food created");
        } else {
            System.out.println("Unknown food type");
        }


        //---------------------------------------
        // module-2
        //----------------------------------------

        foodType = "non-veg"; // | "non-veg"
        food = FoodFactory.createFood(foodType);


        if (food instanceof VegFood) {
            System.out.println("Veg food created");
        } else if (food instanceof NonVegFood) {
            System.out.println("Non-veg food created");
        } else {
            System.out.println("Unknown food type");
        }


    }
}
