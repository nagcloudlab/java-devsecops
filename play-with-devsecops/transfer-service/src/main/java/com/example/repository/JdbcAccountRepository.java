package com.example.repository;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.model.Account;

@Component
@Qualifier("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository {

    @Override
    public Account findByAccountNumber(String number) {
        // Load postgres driver
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:54322/postgres";
            String username = "postgres";
            String password = "postgres";
            connection = java.sql.DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM accounts WHERE number = " + "'" + number + "'";
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String accountNumber = resultSet.getString("number");
                double balance = resultSet.getDouble("balance");
                return new Account(accountNumber, balance);
            } else {
                return null; // Account not found
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL driver not found", e);
        } catch (java.sql.SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (java.sql.SQLException e) {
                    throw new RuntimeException("Error closing the database connection", e);
                }
            }
        }

    }

    @Override
    public void save(Account account) {

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:54322/postgres";
            String username = "postgres";
            String password = "postgres";
            connection = java.sql.DriverManager.getConnection(url, username, password);
            String sql = "UPDATE accounts SET balance = " + account.getBalance() +
                    " WHERE number = '" + account.getNumber() + "'";
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL driver not found", e);
        } catch (java.sql.SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (java.sql.SQLException e) {
                    throw new RuntimeException("Error closing the database connection", e);
                }
            }
        }
    }

}
