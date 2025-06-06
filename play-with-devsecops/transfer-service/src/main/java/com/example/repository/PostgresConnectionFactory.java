package com.example.repository;

import java.sql.Connection;

public class PostgresConnectionFactory {

    private PostgresConnectionFactory() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        try {
            // Create and return a new connection to the database
            return java.sql.DriverManager.getConnection(
                    "jdbc:postgresql://localhost:54322/postgres",
                    "postgres",
                    System.getProperty("POSTGRES_PASSWORD"));
        } catch (Exception e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

}
