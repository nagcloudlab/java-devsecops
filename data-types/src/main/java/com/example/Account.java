package com.example;

import java.lang.*;

public class Account {

    String accountNumber; // null
    double balance; // 0.0
    AccountType accountType; // null


    // default constructor
    //public Account(){}

    // constructor with parameters
    Account(String accountNumber) {
        //this.accountNumber=accountNumber;
        this(accountNumber, 0.0); // this constructor calls the overloaded constructor
    }

    // Overloaded constructor with parameters
    Account(String accountNumber, double balance) {
        if (accountNumber.length() != 9) {
            throw new IllegalArgumentException("Account number must be 9 digits");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be positive");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    void credit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance += amount;
    }

    void debit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (this.balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }


}
