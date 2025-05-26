package com.example;


class Employee {
    double salary;

    public double getBonus() {
        return salary * 0.02;
    }
}

class Manager extends Employee {
    public double getBonus() {
        return super.getBonus() + salary * 0.2;
    }
}

public class InheritanceExample {
    public static void main(String[] args) {

        Employee e = new Employee();
        e.salary = 1000.00;
        System.out.println(e.getBonus());

        Manager manager = new Manager();
        manager.salary = 1000.00;
        System.out.println(manager.getBonus());

    }
}
