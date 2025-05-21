package com.example.live;


// Management code
// Open Closes principle => Polymorphism
public class God {

//    public void manageHuman(Human human) {
//        human.eat();
//        human.sleep();
//        human.study();
//        human.work();
//    }
//
//    public void manageAnimal(Animal animal) {
//        animal.eat();
//        animal.sleep();
//        animal.work();
//    }

    public void manageLT(LivingThing lt) {
        lt.eat();
        lt.sleep();

        if (lt instanceof Human) {
            Human h = (Human) lt;// downcasting (LivingThing to Human if lt is Human)
            h.study();
        }

        lt.work();
    }

}
