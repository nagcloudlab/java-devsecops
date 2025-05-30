package com.example.api;


import com.example.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferApiController {

    @Autowired
    private TransferService transferService;

    /**
     * POST /transfer
     * input : json
     * output : json
     */

    @RequestMapping(value = "/api/transfer",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json")
    public TransferResponse transfer(
            @RequestBody TransferRequest transferRequest
    ) {

        transferService.transfer(transferRequest.getFromAccount(),
                transferRequest.getToAccount(),
                transferRequest.getAmount());

        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setStatus("success");
        transferResponse.setMessage("Transfer completed successfully");
        transferResponse.setTransactionId("23123123123");

        return transferResponse;


    }


}
