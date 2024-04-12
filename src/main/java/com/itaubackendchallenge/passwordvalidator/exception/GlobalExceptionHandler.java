package com.itaubackendchallenge.passwordvalidator.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PasswordInvalidException.class)
    public ResponseEntity<Boolean> handlePasswordInvalidException(PasswordInvalidException e) {
        return ResponseEntity.badRequest().body(false);
    }
}
