
package com.example;

import com.example.dto.TransferRequest;
import com.example.dto.TransferResponse;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UPITransferServiceTest {

    TransferService service;
    AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class); // Mocking the AccountRepository
        service = new UPITransferService(accountRepository);
    }

    @Test
    void testTransferSuccess() {

        Account fromAccount = new Account("A100", 5000.00);
        Account toAccount = new Account("B200", 2000.00);

        // Mocking the behavior of the account repository
        when(accountRepository.findByAccountNumber("A100"))
                .thenReturn(fromAccount);
        when(accountRepository.findByAccountNumber("B200"))
                .thenReturn(toAccount);

        TransferRequest request = new TransferRequest();
        request.setFromAccountNumber("A100");
        request.setToAccountNumber("B200");
        request.setAmount(1000);

        TransferResponse response = service.transfer(request);
        assertEquals("success", response.getStatus());

        // Verify the balances after transfer
        verify(accountRepository, times(2))
                .updateAccount(any(Account.class));
    }

}
