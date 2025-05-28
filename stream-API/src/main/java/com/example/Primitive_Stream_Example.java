package com.example;

import com.example.model.Dish;

import java.util.List;

public class Primitive_Stream_Example {


    public static void main(String[] args) {


        List<Dish> menu = Dish.menu;
        System.out.println(
                menu
                        .stream()
                        .mapToInt(dish -> dish.getCalories())
                        .sum()
        );


    }

}
