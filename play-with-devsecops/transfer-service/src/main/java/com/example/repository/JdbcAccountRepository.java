package com.example.repository;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.exception.DataAccessException;
import com.example.exception.DataUpdateException;
import com.example.model.Account;

@Component
@Qualifier("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository {

    @Override
    public Account findByAccountNumber(String number) {
        try (Connection connection = PostgresConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE number = '" + number + "'";
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Account(
                        resultSet.getString("number"),
                        resultSet.getDouble("balance"));
            } else {
                return null; // Account not found
            }
        } catch (java.sql.SQLException e) {
            throw new DataAccessException(e.getMessage(), e);
        }

    }

    @Override
    public void save(Account account) {
        try (Connection connection = PostgresConnectionFactory.getConnection()) {
            String sql = "UPDATE accounts SET balance = " + account.getBalance() +
                    " WHERE number = '" + account.getNumber() + "'";
            java.sql.Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (java.sql.SQLException e) {
            throw new DataUpdateException("Failed to update account: " + account.getNumber(), e);
        }
    }

}
