package com.example.service;

import com.example.model.Account;
import com.example.reposotory.AccountRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * author : Dev-2
 */

@Component("transferService")
public class UPITransferService implements TransferService {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger("transfer-service");

    private AccountRepository accountRepository; //

    @Autowired
    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService initialized");
    }


    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        logger.info("Transfer initiated from " + fromAccountNumber + " to " + toAccountNumber + " for amount: " + amount);

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
