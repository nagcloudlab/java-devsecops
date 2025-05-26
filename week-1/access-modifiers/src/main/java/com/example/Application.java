package com.example;

import package1.A;
import package1.B;
import package1.C;
import package2.D;
import package2.E;

public class Application {

    public static void main(String[] args) {

        A a = new A();
        a.aInstanceMethod();

        System.out.println("-----------------");

        B b = new B();
        b.bInstanceMethod();

        System.out.println("-----------------");
        C c = new C();
        c.cInstanceMethod();

        System.out.println("-----------------");

        D d = new D();
        d.dInstanceMethod();

        System.out.println("-----------------");

         E e = new E();
        e.eInstanceMethod();
    }

}
