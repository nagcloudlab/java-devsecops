package com.securebank.account;

import com.securebank.account.model.Account;
import com.securebank.account.model.TransferRequest;
import com.securebank.account.repository.AccountRepository;
import com.securebank.account.service.AccountService;
import com.securebank.account.service.TransferService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TransferServiceBDDTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private TransferService transferService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    class ValidTransfer {

        @Test
        void shouldTransferFundsSuccessfully() {
            // given
            Account source = new Account(1L, new BigDecimal("500.00"));
            Account target = new Account(2L, new BigDecimal("200.00"));
            TransferRequest request = new TransferRequest(1L, 2L, new BigDecimal("100.00"));

            given(accountService.findById(1L)).willReturn(Optional.of(source));
            given(accountService.findById(2L)).willReturn(Optional.of(target));

            // when
            transferService.transfer(request.getFromAccountId(), request.getToAccountId(), request.getAmount());

            // then
            verify(accountService).save(source);
            verify(accountService).save(target);

        }
    }

    @Nested
    class InvalidTransfer {

        @Test
        void shouldThrowIfSourceAccountNotFound() {
            TransferRequest request = new TransferRequest(1L, 2L, new BigDecimal("100.00"));

            given(accountService.findById(1L)).willReturn(Optional.empty());

            assertThatThrownBy(() -> transferService.transfer(request.getFromAccountId(), request.getToAccountId(),
                    request.getAmount()))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Source account not found");
        }

        @Test
        void shouldThrowIfInsufficientFunds() {
            Account source = new Account(1L, new BigDecimal("50.00"));
            Account target = new Account(2L, new BigDecimal("200.00"));
            TransferRequest request = new TransferRequest(1L, 2L, new BigDecimal("100.00"));

            given(accountService.findById(1L)).willReturn(Optional.of(source));
            given(accountService.findById(2L)).willReturn(Optional.of(target));

            assertThatThrownBy(() -> transferService.transfer(request.getFromAccountId(), request.getToAccountId(),
                    request.getAmount()))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("Insufficient funds");
        }
    }
}
// This code is a BDD-style test for the TransferService class in a banking
// application.