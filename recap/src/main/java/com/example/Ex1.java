package com.example;

import java.lang.*;

// java-program overview
public class Ex1 {
    public static void main(String[] args){
        System.out.println("Hello Ex1");
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(Thread.currentThread().getName());
        while(true){}
    }
}
