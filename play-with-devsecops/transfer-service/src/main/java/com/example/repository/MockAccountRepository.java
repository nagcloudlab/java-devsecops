
package com.example.repository;

import com.example.model.Account;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Qualifier("mockAccountRepository")
public class MockAccountRepository implements AccountRepository {

    private final Map<String, Account> accountStore = new ConcurrentHashMap<>();

    public MockAccountRepository() {
        // Preload with some mock accounts
        accountStore.put("A100", new Account("A100", 5000));
        accountStore.put("B200", new Account("B200", 3000));
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountStore.get(accountNumber);
    }

    @Override
    public void save(Account account) {
        accountStore.put(account.getNumber(), account);
    }
}
