package com.example.reposotory;

import com.example.model.Account;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * author: dev-1
 */

@Component
public class JdbcAccountRepository implements AccountRepository {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger("transfer-service");

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        logger.info("JdbcAccountRepository initialized");
    }

    public Account findByAccountByNumber(String number) {
        logger.info("Finding account by number: " + number);
        String sql = "SELECT * FROM accounts WHERE number = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Account account = null;
            account = new Account(rs.getString("number"), rs.getDouble("balance"));
            logger.info("Found account: " + account);
            return account;
        }, number);
    }

    public void saveAccount(Account account) {
        logger.info("Saving account: " + account.getNumber());
        String sql = "UPDATE accounts SET balance = ? WHERE number = ?";
        jdbcTemplate.update(sql, account.getBalance(), account.getNumber());
        logger.info("Account saved: " + account.getNumber());
    }

}
