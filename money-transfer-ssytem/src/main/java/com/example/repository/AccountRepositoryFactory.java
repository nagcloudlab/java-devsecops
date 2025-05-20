package com.example.repository;

public class AccountRepositoryFactory {

    public static AccountRepository getAccountRepository(String dbType) {
        if (dbType.equalsIgnoreCase("mysql")) {
            return new MySQLAccountRepository();
        } else if (dbType.equalsIgnoreCase("postgresql")) {
            return new PostgreSQLAccountRepository();
        } else {
            throw new IllegalArgumentException("Unknown database type: " + dbType);
        }
    }

}
