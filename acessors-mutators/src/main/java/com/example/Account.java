package com.example;


// Lombok => code generation library
public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (accountNumber.length() != 9) {
            throw new IllegalArgumentException("Account number must be 9 digits long");
        }
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    // accessor methods
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public double getBalance() {
        return balance;
    }

    // mutator methods
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }




}
