package com.example.repository;

import com.example.model.Account;

public interface AccountRepository {
    Account findByAccountNumber(String number);

    void updateAccount(Account account);
}
