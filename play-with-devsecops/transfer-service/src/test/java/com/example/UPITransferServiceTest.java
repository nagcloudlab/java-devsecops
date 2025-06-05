package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.dto.TransferRequest;
import com.example.dto.TransferResponse;
import com.example.repository.MockAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UPITransferServiceTest {

    TransferService service;

    @BeforeEach
    void setUp() {
        service = new UPITransferService(new MockAccountRepository());
    }

    // Add test methods here
    @Test
    void testTransferSucess() {
        TransferRequest request = new TransferRequest();
        request.setFromAccountNumber("A100");
        request.setToAccountNumber("B200");
        request.setAmount(1000);

        TransferResponse response = service.transfer(request);

        assertEquals("success", response.getStatus());

    }

}
