package com.example.reposotory;

import com.example.model.Account;

public interface AccountRepository {
    public Account findByAccountByNumber(String number);
    public void saveAccount(Account account);
}
