package com.unicorn.exception;

/**
 * Created by klymenko.ruslan on 25.05.2017.
 */
public class NoSuchCreditCardException extends RuntimeException {
    public NoSuchCreditCardException(String message) {
        super(message);
    }
}
