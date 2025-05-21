package com.example;


import java.util.concurrent.TimeUnit;

class Config {
    // class var
    //private static Config config = new Config(); // Eager instantiation
    private static Config config = null;

    private Config() {
        System.out.println("Config object created");
    }

    // class method
    public static synchronized Config getConfig() {
        if (config == null) {
            System.out.println(Thread.currentThread().getName() + " is creating Config object");
//            try {
//                TimeUnit.SECONDS.sleep(1); // Simulate some delay
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            config = new Config(); // Lazy instantiation
            System.out.println(Thread.currentThread().getName() + " created Config object");
        }
        return config;
    }
}


public class SingletonExample {


    public static void main(String[] args) {

        //-----------------------------------
        // module-1
        //-----------------------------------

        Thread t1 = new Thread(() -> {
            Config c1 = Config.getConfig();
            System.out.println("c1: " + c1);
        });
        t1.start();

        //-----------------------------------
        // module-2
        //-----------------------------------

        Thread t2 = new Thread(() -> {
            Config c2 = Config.getConfig();
            System.out.println("c2: " + c2);
        });
        t2.start();

        //-------------------------------------


    }

}
