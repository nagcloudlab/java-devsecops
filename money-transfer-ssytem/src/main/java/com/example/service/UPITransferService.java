package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;

/*

    design issues
    ---------------

    -> tight coupling between UPITransferService and MysqlAccountRepository
        => can't with new features easilt
    -> unit-testing is difficult
        => dev & bug-fix slow

    performance issues
    -------------------

    -> on each transfer, we are creating a new instance of MysqlAccountRepository
        => resource wastage
        => latency

    why these issues?

    => dependent managing it's own dependencies

    solution to design issues ( design patterns ):

    => don't create in dependent's home , get from outisde ( factory )


    solution to performance issues:

    => dont create & get from factory , inject by manager ( depedency inversion principle )



    -------------------------------------------------------
    SOLID principles
    -------------------------------------------------------


    S - Single Responsibility Principle
        => class should have only one reason to change
    O - Open/Closed Principle
        => class should be open for extension but closed for modification
    L - Liskov Substitution Principle
        => derived class should be substitutable for base class
    I - Interface Segregation Principle
        => client should not be forced to depend on interfaces it does not use
    D - Dependency Inversion Principle
        => high level module should not depend on low level module, both should depend on abstractions
        => abstractions should not depend on details, details should depend on abstractions



 */

public class UPITransferService {

    private AccountRepository accountRepository; // has-a dependency

    // constructor injection
    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        System.out.println("UPITransferService component created");
    }

    public boolean transfer(double amount, String from, String to) {

        System.out.println("UPITransferService: transfer() called");

        //MysqlAccountRepository accountRepository = new MysqlAccountRepository(); // Do not create in dependent's home
        //AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository("mysql"); // Dont get from factory

        // load the 'from' account
        Account fromAccount = accountRepository.loadAccount(from);
        // load the 'to' account
        Account toAccount = accountRepository.loadAccount(to);
        // check if the 'from' account has sufficient balance
        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        // debit
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        System.out.println("UPITransferService: debited " + amount + " from " + from);
        // credit
        toAccount.setBalance(toAccount.getBalance() + amount);
        System.out.println("UPITransferService: credited " + amount + " to " + to);
        // update the 'from' account
        accountRepository.updateAccount(fromAccount);
        // update the 'to' account
        accountRepository.updateAccount(toAccount);

        System.out.println("UPITransferService: transfer() completed");

        return true;


    }

}
