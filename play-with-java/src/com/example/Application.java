package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;
import com.example.service.UPITransferService;

public class Application {
    public static void main(String[] args) {

        //---------------------------------------
        // init / boot phase
        //---------------------------------------
        // create & assemble components based config
        AccountRepository accountRepository = AccountRepositoryFactory.getAccountRepository("nosql");
        UPITransferService upiTransferService = new UPITransferService(accountRepository);

        System.out.println();
        System.out.println();
        //---------------------------------------
        // use phase
        //---------------------------------------

        upiTransferService.transfer(100.00, "from@oksbi.com", "to@oksbi.com");
        System.out.println();
        upiTransferService.transfer(100.00, "from@oksbi.com", "to@oksbi.com");


        System.out.println();
        System.out.println();
        //---------------------------------------
        // clean phase
        //---------------------------------------

        upiTransferService = null;

    }
}
