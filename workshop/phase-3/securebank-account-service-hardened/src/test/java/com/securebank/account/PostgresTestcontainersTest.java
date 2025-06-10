package com.securebank.account;

import com.securebank.account.model.Account;
import com.securebank.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostgresTestcontainersTest extends TestcontainersConfig {

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setup() {
        accountRepository.deleteAll();
    }

    @Test
    void shouldSaveAndLoadAccount() {
        Account account = new Account(100L, new BigDecimal("300.00"));
        accountRepository.save(account);

        Account found = accountRepository.findById(100L).orElseThrow();
        assertThat(found.getBalance()).isEqualByComparingTo("300.00");
    }
}
