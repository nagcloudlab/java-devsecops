
package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.MockAccountRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

@Component("transferService")
public class UPITransferService implements TransferService {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger("transfer-service");

    private ExecutorService executorService = Executors.newFixedThreadPool(100);

    private AccountRepository accountRepository;

    @Autowired
    public UPITransferService(@Qualifier("jdbcAccountRepository") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService initialized.");
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        // accountRepository = new MockAccountRepository();
        Runnable transferTask = () -> {
            logger.info("Thread [{}] started transfer", Thread.currentThread().getName());

            Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
            Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);

            // Always lock accounts in consistent order to avoid deadlock
            // Account first = fromAccount.getNumber().compareTo(toAccount.getNumber()) < 0
            // ? fromAccount : toAccount;
            // Account second = first == fromAccount ? toAccount : fromAccount;

            // Lock firstLock = first.getLock();
            // Lock secondLock = second.getLock();

            // firstLock.lock();
            try {
                // secondLock.lock();
                try {
                    fromAccount.setBalance(fromAccount.getBalance() - amount);
                    logger.info("Deducted {} from {}. New balance: {}", amount, fromAccountNumber,
                            fromAccount.getBalance());

                    toAccount.setBalance(toAccount.getBalance() + amount);
                    logger.info("Added {} to {}. New balance: {}", amount, toAccountNumber, toAccount.getBalance());

                    accountRepository.save(fromAccount);
                    accountRepository.save(toAccount);
                    logger.info("Thread [{}] completed transfer", Thread.currentThread().getName());
                } finally {
                    // secondLock.unlock();
                }
            } finally {
                // firstLock.unlock();
            }
        };

        // new Thread(transferTask).start();
        executorService.submit(transferTask);
    }
}
