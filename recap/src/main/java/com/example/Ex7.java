package com.example;

// method overloading

class Actor {
    public void act(int pay1) {
        System.out.println("Single Hero Act");
    }

    public void act(int pay1,int pay2) {
        System.out.println("Double Hero Act");
    }
}

public class Ex7 {

    public static void main(String[] args) {

        Actor actor1 = new Actor();
        actor1.act(100);
        actor1.act(100, 100);

        System.out.println(1);
        System.out.println(1.1);
        System.out.println("hello");

    }

}
