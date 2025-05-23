package com.example;

//---------------------------------------------
//
//---------------------------------------------

/**
 * design issues
 * ---------------
 * -> code tangling / coupling multiple concerns together
 * -> code scattering / duplication
 *
 *
 * Solution:
 * -> Proxy Design Pattern
 *
 */

interface IGreeting {
    void hello();
    void hi();
    void hey();
}
class Greeting implements IGreeting {
    public void hello() {
        System.out.println("Hello");
    }

    //
    public void hi() {
        System.out.println("Hi");
    }

    public void hey() {
        System.out.println("hey");
    }
}
class Emoji {
    public void printSmile() {
        System.out.println("😀");
    }
}
class Auth {
    public void authorize() {
        System.out.println("RBAC");
    }
}
class GreetingProxy implements IGreeting {

    private Emoji emoji = new Emoji();
    private Auth auth = new Auth();
    private Greeting greeting;

    public GreetingProxy(Greeting greeting) {
        this.greeting = greeting;
    }

    public void hello() {
        auth.authorize();
        greeting.hello();
        emoji.printSmile();
    }

    public void hi() {
        greeting.hi();
    }

    public void hey() {
        greeting.hey();
    }
}




public class ProxyPatternExample {
    public static void main(String[] args) {

        Greeting greeting = new Greeting(); // Target
        GreetingProxy greetingProxy = new GreetingProxy(greeting); // proxy
        greetingProxy.hello();


    }
}
