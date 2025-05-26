package com.example.repository;

import com.example.model.Account;

/**
 * author: Jane Doe
 */

public class PostgreSQLAccountRepository implements AccountRepository {

    public PostgreSQLAccountRepository() {
        System.out.println("PostgresAccountRepository component created");
    }

    public Account loadAccount(String accountId) {
        System.out.println("SqlAccountRepository: loadAccount() called");
        // SQL logic to load account
        return new Account(accountId, 1000.0);
    }

    public void updateAccount(Account account) {
        System.out.println("SqlAccountRepository: updateAccount() called");
        // SQL logic to save account
    }

}
