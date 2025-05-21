package com.example;

// Builder pattern example

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getters and toString() method
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

class AccountBuilder {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public AccountBuilder setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public AccountBuilder setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        return this;
    }

    public AccountBuilder setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public Account build() {
        return new Account(accountNumber, accountHolderName, balance);
    }
}


public class BuilderExample {

    public static void main(String[] args) {


        //Account account = new Account("123456789", "John Doe", 1000.0);
        Account account = new AccountBuilder()
                .setAccountNumber("12345")
                .setBalance(1000.0)
                .setAccountHolderName("John Doe")
                .build();

    }

}
