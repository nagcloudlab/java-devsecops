package com.securebank.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securebank.account.model.Account;
import com.securebank.account.model.TransferRequest;
import com.securebank.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        accountRepository.deleteAll();
        accountRepository.save(new Account(1L, new BigDecimal("200.00")));
        accountRepository.save(new Account(2L, new BigDecimal("50.00")));
    }

    @Test
    @DisplayName("Should transfer funds using /transfer API and verify DB")
    void testTransferApi() throws Exception {
        TransferRequest request = new TransferRequest(1L, 2L, new BigDecimal("75.00"));

        mockMvc.perform(post("/api/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        Account from = accountRepository.findById(1L).orElseThrow();
        Account to = accountRepository.findById(2L).orElseThrow();

        assertThat(from.getBalance()).isEqualByComparingTo("125.00");
        assertThat(to.getBalance()).isEqualByComparingTo("125.00");
    }
}
