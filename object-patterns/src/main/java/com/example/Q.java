package com.example;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

interface DoorListener {
    void on();

    void off();
}

// service
class Light implements DoorListener {
    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}

//service
class AC implements DoorListener {
    public void on() {
        System.out.println("AC is on");
    }

    public void off() {
        System.out.println("AC is off");
    }
}

//service
class Projector implements DoorListener {
    public void on() {
        System.out.println("Projector is on");
    }

    public void off() {
        System.out.println("Projector is off");
    }
}


class Door {

    //private DoorListener doorListener;
    private ArrayList<DoorListener> doorListeners = new ArrayList<>();

    public void addDoorListener(DoorListener doorListener) {
        doorListeners.add(doorListener);
    }

    public void removeDoorListener(DoorListener doorListener) {
        doorListeners.remove(doorListener);
    }

    public void open() {
        System.out.println("Door is opened");
//        for (DoorListener doorListener : doorListeners) {
//            doorListener.on();
//        }
    }

    public void close() {
        System.out.println("Door is closed");
        for (DoorListener doorListener : doorListeners) {
            doorListener.off();
        }
    }
}

public class Q {
    public static void main(String[] args) throws InterruptedException {

        Door door = new Door();

        Light light = new Light();
        AC ac = new AC();
        Projector projector = new Projector();

        door.addDoorListener(light);
        door.addDoorListener(ac);
        door.addDoorListener(projector);

        TimeUnit.SECONDS.sleep(3);
        door.open();
        TimeUnit.SECONDS.sleep(3);
        door.close();


        // Remove the light listener
        door.removeDoorListener(projector);

        TimeUnit.SECONDS.sleep(3);
        door.open();
        TimeUnit.SECONDS.sleep(3);
        door.close();

    }
}
