
package com.example.service;

import com.example.dto.TransferRequest;
import com.example.dto.TransferResponse;
import com.example.model.Account;
import com.example.repository.AccountRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("transferService")
public class UPITransferService implements TransferService {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger("transfer-service");

    private AccountRepository accountRepository;

    @Autowired
    public UPITransferService(@Qualifier("jpaAccountRepository") AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        logger.info("UPITransferService initialized.");
    }

    @Override
    @Transactional(transactionManager = "transactionManager", rollbackFor = { RuntimeException.class })
    public TransferResponse transfer(TransferRequest transferRequest) {
        // accountRepository = new MockAccountRepository();
        logger.info("Thread [{}] started transfer", Thread.currentThread().getName());

        String fromAccountNumber = transferRequest.getFromAccountNumber();
        String toAccountNumber = transferRequest.getToAccountNumber();
        double amount = transferRequest.getAmount();

        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);

        if (fromAccount == null) {
            logger.error("From account {} not found", fromAccountNumber);
            throw new IllegalArgumentException("From account not found");
        }
        if (toAccount == null) {
            logger.error("To account {} not found", toAccountNumber);
            throw new IllegalArgumentException("To account not found");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        logger.info("Deducted {} from {}. New balance: {}", amount, fromAccountNumber,
                fromAccount.getBalance());

        toAccount.setBalance(toAccount.getBalance() + amount);
        logger.info("Added {} to {}. New balance: {}", amount, toAccountNumber, toAccount.getBalance());

        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);
        logger.info("Thread [{}] completed transfer", Thread.currentThread().getName());

        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setStatus("success");
        transferResponse.setMessage("Transfer completed successfully");

        return transferResponse;

    }
}
