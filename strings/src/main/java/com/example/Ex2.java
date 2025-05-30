package com.example;

public class Ex2 {
    public static void main(String[] args) {

        // imp-note : string immutable
        String s1="npci";
        String s2="npci";
        System.out.println(s1==s2);
        String ss1=s1.concat("-hyderabad").intern();
        String ss2=s2.concat("-hyderabad").intern();
        System.out.println(ss1==ss2);


    }

}
