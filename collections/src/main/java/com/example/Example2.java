package com.example;

import java.util.ArrayList;
import java.util.List;

public class Example2 {

    public static void main(String[] args) {

        List<String> sheet1 = new ArrayList<>();
        sheet1.add("A");
        sheet1.add("B");
        sheet1.add("C");
        List<String> sheet2 = new ArrayList<>();
        sheet2.add("A");
        sheet2.add("B");
        sheet2.add("D");


        //sheet1.removeAll(sheet2);
        sheet1.retainAll(sheet2);

        System.out.println(sheet1);

    }

}
