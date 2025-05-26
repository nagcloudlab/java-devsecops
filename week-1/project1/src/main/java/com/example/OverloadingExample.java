package com.example;

class Actor {
    void act(int pay1) {
        System.out.println("single-role-act");
    }

    void act(int pay1, int pay2) {
        System.out.println("dual-role-act");
    }
}


public class OverloadingExample {
    public static void main(String[] args) {

        Actor actor = new Actor();
        actor.act(100);
        actor.act(100, 100);


        System.out.println(1);
        System.out.println("hello");
        System.out.println(true);

    }
}
