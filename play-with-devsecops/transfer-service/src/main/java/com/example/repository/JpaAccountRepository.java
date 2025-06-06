package com.example.repository;

import com.example.model.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository("jpaAccountRepository")
public class JpaAccountRepository implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account findByAccountNumber(String number) {
        return entityManager.find(Account.class, number); // SQL - select
    }

    @Override
    public void updateAccount(Account account) {
        entityManager.merge(account); // SQL - update
    }
}
