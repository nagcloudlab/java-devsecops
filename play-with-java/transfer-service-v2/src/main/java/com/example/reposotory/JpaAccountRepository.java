package com.example.reposotory;

import com.example.model.Account;
import org.apache.log4j.Logger;

/**
 * author: dev-1
 */

public class JpaAccountRepository implements AccountRepository{

    private static Logger logger = Logger.getLogger("transfer-service"); // singleton logger

    public JpaAccountRepository() {
        logger.info("JpaAccountRepository initialized");
    }

    public Account findByAccountByNumber(String number) {
        logger.info("Finding account by number: " + number);
        // Simulate loading an account from a database
        return new Account(number, 1000.0);
    }

    public void saveAccount(Account account) {
        logger.info("Saving account: " + account.getNumber());
        // Simulate saving an account to a database
    }

}
