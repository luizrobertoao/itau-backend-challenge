package com.itaubackendchallenge.passwordvalidator.service;

import com.itaubackendchallenge.passwordvalidator.exception.PasswordInvalidException;
import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import com.itaubackendchallenge.passwordvalidator.validator.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordValidator passwordValidator;

    public void validate(PasswordRequest password) {
        if (!passwordValidator.isValid(password)) {
            throw new PasswordInvalidException("Invalid password");
        }
    }
}
