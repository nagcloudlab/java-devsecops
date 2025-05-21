package com.example;

public class Application {
    public static void main(String[] args) {


        TechEmployee techEmployee = new TechEmployee(1, "John Doe", "upi", "Java");
        System.out.println(techEmployee.getId());
        System.out.println(techEmployee.getName());
        System.out.println(techEmployee.getDepartment());
        System.out.println(techEmployee.getTechSkill());

        NonTechEmployee nonTechEmployee = new NonTechEmployee(2, "Jane Doe", "upi");
        System.out.println(nonTechEmployee.getId());
        System.out.println(nonTechEmployee.getName());
        System.out.println(nonTechEmployee.getDepartment());


        Employee e = new TechEmployee(1, "John Doe", "upi", "Java");
        e = new NonTechEmployee(2, "Jane Doe", "upi");

    }
}
