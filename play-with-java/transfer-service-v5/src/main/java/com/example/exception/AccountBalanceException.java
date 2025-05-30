package com.example.exception;

public class AccountBalanceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccountBalanceException(String message) {
        super(message);
    }

    public AccountBalanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
