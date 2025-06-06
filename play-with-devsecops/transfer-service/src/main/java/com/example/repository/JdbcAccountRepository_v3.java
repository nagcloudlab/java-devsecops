package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
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

@Repository
@Qualifier("jdbcAccountRepository")
public class JdbcAccountRepository_v3 implements AccountRepository {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger("transfer-service");

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountRepository_v3(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Account findByAccountNumber(String number) {
        String sql = "SELECT number, balance FROM accounts WHERE number = ?";
        Account account = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Account acc = new Account();
            acc.setNumber(rs.getString("number"));
            acc.setBalance(rs.getDouble("balance"));
            return acc;
        }, number);

        if (account == null) {
            logger.warn("Account with number {} not found", number);
        }
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "UPDATE accounts SET balance = ? WHERE number = ?";
        int rowsAffected = jdbcTemplate.update(sql, account.getBalance(), account.getNumber());
        if (rowsAffected == 0) {
            logger.warn("No account found with number {}", account.getNumber());
        } else {
            logger.info("Account {} updated successfully", account.getNumber());
        }
    }
}
