package com.example.model;

public class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    // Implementing Comparable interface to allow sorting

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + '}';
    }
}
