package package1;

public class C {

    A a = new A(); // composition ( has-a relationship)

    public void cInstanceMethod(){
        System.out.println("C instance method");
        //System.out.println("pri: " + a.pri);
        System.out.println("def: " + a.def);
        System.out.println("pro: " + a.pro);
        System.out.println("pub: " + a.pub);
    }

}
