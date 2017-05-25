package com.unicorn.exception;

/**
 * Created by klymenko.ruslan on 24.05.2017.
 */
public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
