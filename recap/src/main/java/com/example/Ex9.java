package com.example;

class E{
    double salary;
    public double askForBonus(){
        return salary * 0.02;
    }
}

class M extends  E{
    @Override
    public double askForBonus() {
        return super.askForBonus() + salary * 0.2;
    }
}

public class Ex9 {
    public static void main(String[] args) {

        E employee=new E();
        employee.salary=1000.00;
        System.out.println(employee.askForBonus());


        M m=new M();
        m.salary=1000.00;
        System.out.println(m.askForBonus());

    }
}
