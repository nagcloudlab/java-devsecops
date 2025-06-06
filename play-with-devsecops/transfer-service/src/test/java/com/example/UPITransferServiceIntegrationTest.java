package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.dto.TransferRequest;
import com.example.dto.TransferResponse;
import com.example.service.TransferService;

@SpringBootTest
@ContextConfiguration(classes = { TrafficSimulator.class }) // Ensure the TrafficSimulator class is used for context
public class UPITransferServiceIntegrationTest {

    @Autowired
    private TransferService service;

    // @Test
    void testTransferSuccess() {

        TransferRequest request = new TransferRequest();
        request.setFromAccountNumber("1234567890");
        request.setToAccountNumber("0987654321");
        request.setAmount(1000);

        TransferResponse response = service.transfer(request);
        assertEquals("success", response.getStatus());

    }

}
