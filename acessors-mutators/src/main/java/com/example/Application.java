package com.example;

public class Application {
    public static void main(String[] args) {


        //-----------------------------
        // developer1
        //-----------------------------

        Account account = new Account("123456789", "John Doe", 1000.0);


        //-----------------------------
        // developer2
        //-----------------------------

        //account.balance = -1000.0;
        account.setBalance(-1000.0);


        //-----------------------------
        // developer3
        //-----------------------------

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder Name: " + account.getAccountHolderName());
        System.out.println("Balance: " + account.getBalance());

    }
}
