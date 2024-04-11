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

    public boolean validate(PasswordRequest password) {
        boolean isValid = passwordValidator.isValid(password);
        if (!isValid) {
            throw new PasswordInvalidException("Invalid password");
        }
        return true;
    }
}
