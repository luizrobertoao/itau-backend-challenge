package com.itaubackendchallenge.paswordvalidator.controller;

import com.itaubackendchallenge.paswordvalidator.model.Password;
import com.itaubackendchallenge.paswordvalidator.service.PasswordService;
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
    public ResponseEntity<Void> validatePassword(@RequestBody Password password) {
        passwordService.validate(password);
        return ResponseEntity.ok().build();
    }
}
