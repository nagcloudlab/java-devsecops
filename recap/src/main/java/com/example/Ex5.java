package com.example;


class Foo {
    static int staVar;
    int insVar;

    static void staMethod() {
        System.out.println(staVar);
        //System.out.println(insVar);
    }

    void insMethod() {
        System.out.println(staVar);
        System.out.println(insVar);
    }
}

public class Ex5 {
    public static void main(String[] args) {

        Foo foo = new Foo();

        System.out.println(Foo.staVar);
        System.out.println(foo.insVar);

        Foo.staMethod();


        //-


    }
}
