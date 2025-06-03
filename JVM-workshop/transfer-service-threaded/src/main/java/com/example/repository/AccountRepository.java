package com.example.repository;

import com.example.model.Account;

public interface AccountRepository {
    Account findByAccountNumber(String number);

    void save(Account account);
}
