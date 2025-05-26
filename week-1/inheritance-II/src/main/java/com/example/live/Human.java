package com.example.live;


/**
 * author : A
 */
public class Human extends LivingThing {


    public void study() {
        System.out.println("Human studying");
    }

    @Override
    public void work() {
        System.out.println("Human working");
    }

}
