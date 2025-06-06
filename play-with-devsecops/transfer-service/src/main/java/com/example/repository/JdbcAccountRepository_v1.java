package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

/*
 * 
 * steps to use JDBC api:
 * 
 * 1. Load the JDBC driver
 * 2. Establish a connection to the database
 * 3. Create a statement or prepared statement with SQL query
 * 4. Execute the query
 * 5. Process the result set (if applicable)
 * 6. Close the resources (result set, statement, connection)
 * 7. Handle exceptions
 * 8. Make sure you satisfy the ACID properties of transactions
 * 
 */

// @Repository
@Qualifier("jdbcAccountRepository")
public class JdbcAccountRepository_v1 implements AccountRepository {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger("transfer-service");

    @Override
    public Account findByAccountNumber(String number) {

        PreparedStatement preparedStatement = null;
        try (Connection connection = PostgresConnectionFactory.getConnection()) {
            // 3 Create a statement or prepared statement with SQL query
            String sql = "SELECT number, balance FROM accounts WHERE number = ?";
            preparedStatement = connection.prepareStatement(sql);
            // Set the parameter for the prepared statement
            preparedStatement.setString(1, number);
            // 4. Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            // 5. Process the result set (if applicable)
            Account account = new Account();
            if (resultSet.next()) {
                account.setNumber((resultSet.getString("number")));
                account.setBalance(resultSet.getDouble("balance"));
            } else {
                // Handle the case where no account is found
                account = null;
            }
            // 6. Close the resources (result set, statement, connection)
            return account;
        } catch (Exception e) {
            logger.error("Error finding account by number: {}", e.getMessage());
            return null; // Handle exceptions appropriately
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    logger.error("Error closing prepared statement: {}", e.getMessage());
                }
            }
        }

    }

    @Override
    public void updateAccount(Account account) {

        PreparedStatement preparedStatement = null;
        try (Connection connection = PostgresConnectionFactory.getConnection()) {
            // 3. Create a statement or prepared statement with SQL query
            String sql = "UPDATE accounts SET balance = ? WHERE number = ?";
            preparedStatement = connection.prepareStatement(sql);
            // Set the parameters for the prepared statement
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setString(2, account.getNumber());
            // 4. Execute the query
            preparedStatement.executeUpdate();
            // 6. Close the resources (result set, statement, connection)
            preparedStatement.close();
        } catch (Exception e) {
            logger.error("Error updating account: {}", e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    logger.error("Error closing prepared statement: {}", e.getMessage());
                }
            }
        }
    }
}
