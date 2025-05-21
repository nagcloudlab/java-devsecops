package com.example.live;


/**
 * author: D
 */

public class Robot extends LivingThing {

    @Override
    public void eat() {
        System.out.println("Robot is charging...");
    }

    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
}
