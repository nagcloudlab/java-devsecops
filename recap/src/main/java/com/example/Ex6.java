package com.example;

class Bar {

    static void sm1() {
    }

    static void sm2() {
        sm1();
        //im1();
    }

    void im1() {
    }

    void im2() {
        im1();
        sm1();
    }

}

public class Ex6 {

    public static void main(String[] args) {

        Bar.sm1();
        new Bar().im1();

    }

}
