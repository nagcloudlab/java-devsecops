package com.example.repository;

import com.example.model.Account;

/**
 * team : accounts-team
 */

public class SqlAccountRepository {

    public SqlAccountRepository(){
        System.out.println("SqlAccountRepository component created..");
    }

    public Account loadAccount(String accountNumber) {
        System.out.println("loading account - "+accountNumber);
        // JDBC tech
        // SQL
        Account account = new Account();
        account.accountNumber = accountNumber;
        account.balance = 1000.00;
        return account;
    }


    public void updateAccount(Account account) {
        System.out.println("updating account - "+account.accountNumber);
        //...
    }

}
