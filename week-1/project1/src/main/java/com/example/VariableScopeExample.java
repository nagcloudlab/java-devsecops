package com.example;

class Person {

    static int count;
    String name;

    //int count; // instance
    Person() {
    }

    void sayHello() {
        //int count = 0; // local
        count++;
        System.out.println("Hello from - " + name + "(" + count + ")");
    }
}


public class VariableScopeExample {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.name = "John";

        Person p2 = new Person();
        p2.name = "Jane";

        p1.sayHello();
        p2.sayHello();
        p1.sayHello();


    }
}
