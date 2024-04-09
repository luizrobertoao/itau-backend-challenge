package com.itaubackendchallenge.paswordvalidator.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordInvalidException extends RuntimeException {

    public PasswordInvalidException(String message) {
        super(message);
    }

}
