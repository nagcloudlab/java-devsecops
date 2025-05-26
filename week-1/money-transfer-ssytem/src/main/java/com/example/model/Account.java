package com.example.model;


class Foo{}
interface Bar{}

public class Account {

    private String accountId;
    private double balance;

    public Account(String accountId, double balance) {
        // initialization of fields
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
