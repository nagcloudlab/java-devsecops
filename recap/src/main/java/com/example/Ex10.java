package com.example;

interface I1{
    void m1();
    void m2();
}

interface I2{
    void m3();
    void m4();
}

interface  I extends I1,I2{
    void m5();
}

class C implements  I{
    @Override
    public void m5() {

    }

    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }
}
abstract class CC implements  I{
    public void m1(){}
}
class CCC extends CC{

    @Override
    public void m5() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }
}


public class Ex10 {

    public static void main(String[] args) {

    }

}
