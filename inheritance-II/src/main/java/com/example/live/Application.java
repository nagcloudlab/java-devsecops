package com.example.live;

import java.util.ArrayList;
import java.util.LinkedList;

public class Application {
    public static void main(String[] args) {

        God god = new God();


        Human human = new Human();
        Animal animal = new Animal();

        System.out.println("-----------------");
        System.out.println("Human");
        System.out.println("-----------------");
        god.manageLT(human); // upcasting ( Human to LivingThing)

        System.out.println("-----------------");
        System.out.println("Animal");
        System.out.println("-----------------");
        //god.manageAnimal(animal);
        god.manageLT(animal);


        System.out.println("-----------------");
        System.out.println("Robot");
        System.out.println("-----------------");

        Robot robot = new Robot();
        god.manageLT(robot);


        ArrayList list=new ArrayList();
        LinkedList list2=new LinkedList();

    }
}
