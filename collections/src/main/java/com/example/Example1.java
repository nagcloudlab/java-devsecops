package com.example;

import com.example.util.LinkedList;

public class Example1 {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("data1");
        linkedList.add("data2");
        linkedList.add("data3");

        //String data=linkedList.get(2);

        // iteration..
        for (String e : linkedList) {
            System.out.println(e);
        }

    }

}
