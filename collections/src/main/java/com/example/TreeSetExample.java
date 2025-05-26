package com.example;

import com.example.model.Employee;

import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {

        //List<Employee> employees = new ArrayList<>();

        Comparator<Employee> ageComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        };
        Set<Employee> employees = new TreeSet<>(ageComparator);
        employees.add(new Employee("John Doe", 31));
        employees.add(new Employee("Jane Smith", 25));
        employees.add(new Employee("John Doe", 32)); // Duplicate entry

        for (Employee employee : employees) {
            System.out.println(employee);
        }


    }
}
