package com.example.exception;

public class DataUpdateException extends RuntimeException {

    public DataUpdateException(String message) {
        super(message);
    }

    public DataUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataUpdateException(Throwable cause) {
        super(cause);
    }

}
