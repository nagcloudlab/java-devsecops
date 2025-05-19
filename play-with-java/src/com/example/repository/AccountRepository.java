package com.example.repository;

import com.example.model.Account;

public interface AccountRepository {
   Account loadAccount(String accountNumber);
   void updateAccount(Account account);
}
