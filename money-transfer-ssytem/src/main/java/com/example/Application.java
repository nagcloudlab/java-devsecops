package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.AccountRepositoryFactory;
import com.example.service.UPITransferService;



public class Application {
    public static void main(String[] args) {

        //-----------------------------------------
        // init / boot phase ( manager )
        //-----------------------------------------

        // based configuration
        // we initialize & assemble the application
        AccountRepository mysqlAccountRepository = AccountRepositoryFactory.getAccountRepository("postgresql");
        UPITransferService upiTransferService = new UPITransferService(mysqlAccountRepository);


        System.out.println();
        System.out.println();
        //-----------------------------------------
        // use/run phase
        //-----------------------------------------

        upiTransferService.transfer(100.00, "user1", "user2");
        System.out.println();
        upiTransferService.transfer(200.00, "user2", "user3");


        System.out.println();
        System.out.println();
        //-----------------------------------------
        // shutdown phase
        //-----------------------------------------
        // we can do some cleanup if needed

    }
}
