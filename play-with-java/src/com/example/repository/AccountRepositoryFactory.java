package com.example.repository;

public class AccountRepositoryFactory {

    public static AccountRepository getAccountRepository(String type){
        if(type.equals("sql")){
            return new SqlAccountRepository();
        }else if(type.equals("nosql")){
            return new NoSqlAccountRepository();
        }else{
            throw new IllegalArgumentException("not supported");
        }
    }

}
