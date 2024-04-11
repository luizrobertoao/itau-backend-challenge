package com.itaubackendchallenge.passwordvalidator.unit;

import com.itaubackendchallenge.passwordvalidator.exception.PasswordInvalidException;
import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import com.itaubackendchallenge.passwordvalidator.service.PasswordService;
import com.itaubackendchallenge.passwordvalidator.validator.PasswordValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordServiceTest {

    private PasswordService passwordService;

    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
        passwordService = new PasswordService(passwordValidator);
    }

    @Test
    void shouldReturnTrueWhenPasswordIsValid() {
        PasswordRequest passwordRequest = new PasswordRequest("ValiDPAsSword1!");

        assertTrue(passwordService.validate(passwordRequest));
    }

    @Test
    void shouldThrowExceptionWhenPasswordIsInvalid() {
        PasswordRequest passwordRequest = new PasswordRequest("aBcdef1!");

        assertThrows(PasswordInvalidException.class, () -> passwordService.validate(passwordRequest));
    }
}
