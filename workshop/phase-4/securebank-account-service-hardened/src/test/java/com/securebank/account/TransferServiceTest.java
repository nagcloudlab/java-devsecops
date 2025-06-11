package com.securebank.account;

import com.securebank.account.model.Account;
import com.securebank.account.service.AccountService;
import com.securebank.account.service.TransferService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

public class TransferServiceTest {

    private AccountService accountService;
    private TransferService transferService;

    @BeforeEach
    void setup() {
        accountService = mock(AccountService.class);
        transferService = new TransferService(accountService);
    }

    @Nested
    @DisplayName("Valid transfer scenarios")
    class ValidTransfers {

        @ParameterizedTest
        @CsvSource({
                "100.00, 50.00, 30.00, 70.00, 80.00",
                "200.00, 0.00, 100.00, 100.00, 100.00"
        })
        @DisplayName("Should transfer funds between accounts")
        void testTransfer(BigDecimal fromBalance, BigDecimal toBalance, BigDecimal amount,
                BigDecimal expectedFrom, BigDecimal expectedTo) {

            Account from = new Account(1L, fromBalance);
            Account to = new Account(2L, toBalance);

            given(accountService.findById(1L)).willReturn(Optional.of(from));
            given(accountService.findById(2L)).willReturn(Optional.of(to));

            transferService.transfer(1L, 2L, amount);

            ArgumentCaptor<Account> accountCaptor = ArgumentCaptor.forClass(Account.class);
            verify(accountService, times(2)).save(accountCaptor.capture());

            var savedAccounts = accountCaptor.getAllValues();
            assertThat(savedAccounts).hasSize(2);
            assertThat(savedAccounts)
                    .anyMatch(a -> a.getId().equals(1L) && a.getBalance().compareTo(expectedFrom) == 0);
            assertThat(savedAccounts).anyMatch(a -> a.getId().equals(2L) && a.getBalance().compareTo(expectedTo) == 0);
        }
    }

    @Nested
    @DisplayName("Invalid transfer scenarios")
    class InvalidTransfers {

        @Test
        @DisplayName("Should throw if source account not found")
        void testSourceAccountNotFound() {
            given(accountService.findById(1L)).willReturn(Optional.empty());

            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> transferService.transfer(1L, 2L, new BigDecimal("50.00")));
        }

        @Test
        @DisplayName("Should throw if insufficient funds")
        void testInsufficientFunds() {
            Account from = new Account(1L, new BigDecimal("20.00"));
            Account to = new Account(2L, new BigDecimal("30.00"));

            given(accountService.findById(1L)).willReturn(Optional.of(from));
            given(accountService.findById(2L)).willReturn(Optional.of(to));

            Assertions.assertThrows(IllegalStateException.class,
                    () -> transferService.transfer(1L, 2L, new BigDecimal("50.00")));
        }
    }
}
