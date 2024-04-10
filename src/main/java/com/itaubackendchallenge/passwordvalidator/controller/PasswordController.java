package com.itaubackendchallenge.passwordvalidator.controller;

import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import com.itaubackendchallenge.passwordvalidator.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
@RequiredArgsConstructor
public class PasswordController {
    private final PasswordService passwordService;

    @PostMapping("/validate")
    public ResponseEntity<Void> validatePassword(@RequestBody PasswordRequest password) {
        passwordService.validate(password);
        return ResponseEntity.ok().build();
    }
}
