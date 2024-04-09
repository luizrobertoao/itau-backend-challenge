package com.itaubackendchallenge.paswordvalidator.service;

import com.itaubackendchallenge.paswordvalidator.exception.PasswordInvalidException;
import com.itaubackendchallenge.paswordvalidator.model.Password;
import com.itaubackendchallenge.paswordvalidator.validator.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordValidator passwordValidator;

    public void validate(Password password) {
        if (!passwordValidator.isValid(password)) {
            throw new PasswordInvalidException("Invalid password");
        }
    }
}
