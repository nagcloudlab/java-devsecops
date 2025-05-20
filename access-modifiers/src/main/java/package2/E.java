package package2;

import package1.A;

public class E {

    A a = new A(); // composition ( has-a relationship)

    public void eInstanceMethod() {
        System.out.println("E instance method");
//        System.out.println("pri: " + a.pri);
//        System.out.println("def: " + a.def);
//        System.out.println("pro: " + a.pro);
        System.out.println("pub: " + a.pub);
    }

}
