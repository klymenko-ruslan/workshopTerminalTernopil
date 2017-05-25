package com.unicorn.exception;

/**
 * Created by klymenko.ruslan on 25.05.2017.
 */
public class WrongAuthoritiesException extends RuntimeException {
    public WrongAuthoritiesException(String message) {
        super(message);
    }
}
