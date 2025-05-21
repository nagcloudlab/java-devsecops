package com.example.live;

/**
 * author: Nag
 */

public abstract class LivingThing {
    // data variables
    // constructor
    // behavior methods

    public void eat() {
        System.out.println("LT Eating...");
    }

    public void sleep() {
        System.out.println("LT Sleeping...");
    }

    public abstract void work();

}
