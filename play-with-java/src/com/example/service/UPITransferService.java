package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;

/**
 * team: upi-team
 */


/*

    design issues
    ------------

    -> tight-coupling b/w dependent & dependency..
        => can't extend app with new features easily
    -> unit testing not possible
        => dev / bug-fix slow

    performance issues
    -------------------

    -> too many dependencies created & left as garbage
        => resource usage high
        => latency


    why these issues ?

    -> dependent itself managing its own dependency

    solution to design issues:

    -> Dont' create dependency in dependent's home, , get/lookup on factory ( Factory design pattern )


    solution to performance issues:

    -> Don't create/lookup dependency , ask someone to inject
        ( dependency inversion principle )

        how to inject dependency

        -> constructor
        -> method

 */

public class UPITransferService {

    private AccountRepository accountRepository;

    public UPITransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        System.out.println("UPITransferService component created..");
    }

    public void transfer(double amount, String from, String to) {

        System.out.println("transfer initiated..");

        //SqlAccountRepository accountRepository = new SqlAccountRepository(); // Don't create
        //AccountRepository accountRepository= AccountRepositoryFactory.getAccountRepository("sql"); // don't
        // Load 'from' account details
        Account fromAccount = accountRepository.loadAccount(from);
        // Load 'to' account details
        Account toAccount = accountRepository.loadAccount(to);
        // check
        if (fromAccount.balance < amount)
            throw new IllegalStateException("No enough balance");
        // debit
        fromAccount.balance = fromAccount.balance - amount;
        // credit
        toAccount.balance = toAccount.balance + amount;
        // update both accounts
        accountRepository.updateAccount(fromAccount);
        accountRepository.updateAccount(toAccount);

        System.out.println("transfer successful");

    }

}
