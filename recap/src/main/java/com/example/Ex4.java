package com.example;


class Employee {

    static int count=0; // class
    long id;
    String name;
    //int count=0; // instance

    public Employee() {
    }

    public void sayHello() {
        //var count=0; // Local
        count++;
        System.out.println("Hello , from " + this.name +" -> "+count);
    }

}

public class Ex4 {

    public static void main(String[] args) {

        var e = new Employee();
        e.id = 1;
        e.name = "A";

        var e2 = new Employee();
        e2.id = 2;
        e2.name = "B";

        e.sayHello();
        e.sayHello();
        e2.sayHello();


    }

}
