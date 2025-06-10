package com.securebank.account.service;

import com.securebank.account.model.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {

    private final AccountService accountService;

    public TransferService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        Account from = accountService.findById(fromId)
            .orElseThrow(() -> new IllegalArgumentException("Source account not found"));

        Account to = accountService.findById(toId)
            .orElseThrow(() -> new IllegalArgumentException("Destination account not found"));

        if (from.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient funds");
        }

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        accountService.save(from);
        accountService.save(to);
    }
}
