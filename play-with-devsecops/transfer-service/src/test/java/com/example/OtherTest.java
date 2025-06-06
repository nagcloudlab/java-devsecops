package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.dto.TransferRequest;
import com.example.dto.TransferResponse;
import com.example.exception.DataAccessException;
import com.example.exception.DataUpdateException;
import com.example.model.Account;
import com.example.repository.PostgresConnectionFactory;

class OtherTest {

    @BeforeEach
    void setUp() {
        System.setProperty("POSTGRES_PASSWORD", "postgres");
    }

    @Test
    void testGetConnection() throws Exception {
        assertNotNull(PostgresConnectionFactory.getConnection());
    }

    @Test
    void testDataAccessException() {
        Exception ex = new DataAccessException("Test error");
        assertEquals("Test error", ex.getMessage());
    }

    @Test
    void testDataUpdateException() {
        Exception ex = new DataUpdateException("update error");
        assertEquals("update error", ex.getMessage());
    }

    @Test
    void testTransferRequestSettersAndGetters() {
        TransferRequest req = new TransferRequest();
        req.setFromAccountNumber("A");
        req.setToAccountNumber("B");
        req.setAmount(1000);
        assertEquals("A", req.getFromAccountNumber());
        assertEquals("B", req.getToAccountNumber());
        assertEquals(1000, req.getAmount());
    }

    @Test
    void testTransferRequestSetters() {
        TransferRequest r = new TransferRequest();
        r.setFromAccountNumber("A");
        r.setToAccountNumber("B");
        r.setAmount(500);
        assertEquals("A", r.getFromAccountNumber());
        assertEquals("B", r.getToAccountNumber());
        assertEquals(500, r.getAmount());
    }

    @Test
    void testAccountModel() {
        Account a = new Account("X", 1000);
        assertEquals("X", a.getNumber());
        assertEquals(1000, a.getBalance());

        a.setBalance(2000);
        assertEquals(2000, a.getBalance());
    }

    @Test
    void testTransferResponseModel() {
        TransferResponse r = new TransferResponse("success", "done");
        assertEquals("success", r.getStatus());
        assertEquals("done", r.getMessage());

        r.setStatus("fail");
        r.setMessage("error");
        assertEquals("fail", r.getStatus());
        assertEquals("error", r.getMessage());
    }

    @Test
    void testAccountModelAccessors() {
        Account acc = new Account("X123", 5000.0);
        assertEquals("X123", acc.getNumber());
        assertEquals(5000.0, acc.getBalance());

        acc.setBalance(6000.0);
        assertEquals(6000.0, acc.getBalance());
    }

}
