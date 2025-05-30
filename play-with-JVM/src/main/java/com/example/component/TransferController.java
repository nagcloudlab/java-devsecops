package com.example.component;

import com.example.container.RequestMapping;

public class TransferController {

    @RequestMapping(url = "/transfer", method = "POST")
    public void bar(String source, String destination) {
        // Logic to transfer data from source to destination
        System.out.println("Transferring data from " + source + " to " + destination);
    }

}
