package com.example.reposotory;

public class AccountRepositoryFactory {

    public static AccountRepository getAccountRepository(String dataAccessTechnology) {
        if (dataAccessTechnology.equalsIgnoreCase("jdbc")) {
            //return new JdbcAccountRepository();
            return null;
        } else if (dataAccessTechnology.equalsIgnoreCase("jpa")) {
            return new JpaAccountRepository();
        } else {
            throw new IllegalArgumentException("Unsupported data access technology: " + dataAccessTechnology);
        }
    }
}
