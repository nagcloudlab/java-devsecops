package com.example;


class A extends Object {
    A(int i) {
        super();
        System.out.println("A's constructor");
    }
}

class B extends A {
    B(int i) {
        super(i);
        System.out.println("B's constructor");
    }
}

class C extends B {
    C(int i) {
        super(i);
        System.out.println("C's constructor");
    }
}

public class ConstructorExecutionFlow {
    public static void main(String[] args) {


        C c = new C(10);

    }
}
