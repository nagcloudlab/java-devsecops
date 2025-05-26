package com.example;

class C1 {

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


public class VariableUseExample {

    int v = 100;

    public static void main(String[] args) {

        C1 c1 = new C1();

        System.out.println(C1.staVar);
        System.out.println(c1.insVar);

        C1.staMethod();
        c1.insMethod();

        VariableUseExample variableUseExample = new VariableUseExample();
        System.out.println(variableUseExample.v);

    }
}
