package com.example;

import com.example.reposotory.AccountRepository;
import com.example.reposotory.AccountRepositoryFactory;
import com.example.reposotory.JdbcAccountRepository;
import com.example.reposotory.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;

public class Application {
    public static void main(String[] args) {

        //-------------------------------------------------
        // init / boot phase
        //-------------------------------------------------
        // intilize & assemble the components

        AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository("jdbc");
        TransferService transferService = new UPITransferService(accountRepository);


        System.out.println();
        System.out.println();
        //-------------------------------------------------
        // run phase
        //-------------------------------------------------

        transferService.transfer("user1@upi", "user2@upi", 100.0);
        System.out.println();
        transferService.transfer("user1@upi", "user2@upi", 200.0);


        System.out.println();
        System.out.println();
        //-------------------------------------------------
        // shutdown phase
        //-------------------------------------------------
        // clean up resources if needed

    }
}
