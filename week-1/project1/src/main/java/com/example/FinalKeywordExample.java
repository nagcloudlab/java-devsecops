package com.example;


class Foo {
    final static int staVar = 10; // compile-time value
    final int ins;

    Foo(int v) {
        this.ins = v; // runtime-value, while instantiating
    }

    void insMethod() {
        final int loc = 10;
        //loc=11;
    }
}


// senior
abstract class A {
    abstract void m1();

    final void m2() {
    }
}

// junior
class B extends A {
    void m1() {
    }
    //void m2(){}
}


final class P {
}
//class Q extends P{}


public class FinalKeywordExample {
    public static void main(String[] args) {

        Foo foo = new Foo(10);
        foo.insMethod();


    }
}
