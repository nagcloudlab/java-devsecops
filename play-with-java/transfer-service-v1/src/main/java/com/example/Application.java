package com.example;

import com.example.service.UPITransferService;

public class Application {
    public static void main(String[] args) {

        //-------------------------------------------------
        // init / boot phase
        //-------------------------------------------------
        // intilize & assemble the components

        UPITransferService upiTransferService = new UPITransferService();


        System.out.println();
        System.out.println();
        //-------------------------------------------------
        // run phase
        //-------------------------------------------------

        upiTransferService.transfer("user1@upi", "user2@upi", 100.0);
        System.out.println();
        upiTransferService.transfer("user1@upi", "user2@upi", 200.0);


        System.out.println();
        System.out.println();
        //-------------------------------------------------
        // shutdown phase
        //-------------------------------------------------
        // clean up resources if needed

    }
}
