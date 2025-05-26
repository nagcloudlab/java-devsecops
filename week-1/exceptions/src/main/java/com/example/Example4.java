package com.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Example4 {


    public static void m1() {
        //
        throw new RuntimeException();
    }

    public static void m2() {
        m1();
    }


    public static void m3() {
        try {
            m2();
        } catch (RuntimeException e) {
            //.
        }
    }

    public static void main(String[] args) {

        try {
            Connection connection = null;
            connection.prepareStatement("select unknownclumn from table");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        m3();

    }

}
