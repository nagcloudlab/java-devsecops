package com.example;

class Xyz {

    final static int sta = 1;
    final int ins;

    public Xyz(int v) {
        this.ins = v;
    }

    void m1() {
        final int local = 0;
        //local = 10;
    }

}


abstract class Super {
    abstract void m1();

    final void m2() {
    }
}

class Sub extends Super {
    void m1() {
    }
    //void m2(){}
}



final class C1{}
//class C2 extends C1{}


//class MyString extends String{}

public class Ex8 {
    public static void main(String[] args) {

        Xyz xyz = new Xyz(1);
        //xyz.ins = 10;


    }
}
