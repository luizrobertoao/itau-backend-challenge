package com.itaubackendchallenge.passwordvalidator.controller;

import com.itaubackendchallenge.passwordvalidator.exception.PasswordInvalidException;
import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import com.itaubackendchallenge.passwordvalidator.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v01/password-validations")
@RequiredArgsConstructor
public class PasswordController {
    private final PasswordService passwordService;

    @PostMapping
    public ResponseEntity<Boolean> validatePassword(@RequestBody PasswordRequest password) {
        return ResponseEntity.ok(passwordService.validate(password));
    }

    @ExceptionHandler(PasswordInvalidException.class)
    public ResponseEntity<Boolean> handlePasswordInvalidException(PasswordInvalidException e) {
        return ResponseEntity.badRequest().body(false);
    }
}
