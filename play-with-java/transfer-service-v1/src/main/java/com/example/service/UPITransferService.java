package com.example.service;

import com.example.model.Account;
import com.example.reposotory.JdbcAccountRepository;
import org.apache.log4j.Logger;

public class UPITransferService {

    private static Logger logger = Logger.getLogger("transfer-service"); // singleton logger

    public UPITransferService() {
        logger.info("UPITransferService initialized");
    }


    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        logger.info("Transfer initiated from " + fromAccountNumber + " to " + toAccountNumber + " for amount: " + amount);
        JdbcAccountRepository accountRepository = new JdbcAccountRepository();

        Account fromAccount = accountRepository.findByAccountByNumber(fromAccountNumber);
        Account toAccount = accountRepository.findByAccountByNumber(toAccountNumber);


        fromAccount.setBalance(fromAccount.getBalance() - amount);
        logger.info("debit account: " + fromAccount);
        toAccount.setBalance(toAccount.getBalance() + amount);
        logger.info("credit account: " + toAccount);

        accountRepository.saveAccount(fromAccount);
        accountRepository.saveAccount(toAccount);


        logger.info("Transfer completed successfully from " + fromAccountNumber + " to " + toAccountNumber);
    }

}
