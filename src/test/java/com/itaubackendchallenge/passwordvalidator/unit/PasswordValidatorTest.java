package com.itaubackendchallenge.passwordvalidator.unit;

import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import com.itaubackendchallenge.passwordvalidator.validator.PasswordValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    void shouldReturnFalseWhenPasswordIsNull() {
        PasswordRequest passwordRequest = new PasswordRequest(null);
        assertFalse(passwordValidator.isValid(passwordRequest));
    }

    @Test
    void shouldReturnFalseWhenPasswordIsLessThanNineCharacters() {
        PasswordRequest passwordRequest = new PasswordRequest("aBcdef1!");
        assertFalse(passwordValidator.isValid(passwordRequest));
    }

    @Test
    void shouldReturnFalseWhenPasswordDoesNotContainDigit() {
        PasswordRequest passwordRequest = new PasswordRequest("aBcdefgh!");
        assertFalse(passwordValidator.isValid(passwordRequest));
    }

    @Test
    void shouldReturnFalseWhenPasswordDoesNotContainLowerCaseLetter() {
        PasswordRequest passwordRequest = new PasswordRequest("ABCDEFGH1!");
        assertFalse(passwordValidator.isValid(passwordRequest));
    }

    @Test
    void shouldReturnFalseWhenPasswordDoesNotContainUpperCaseLetter() {
        PasswordRequest passwordRequest = new PasswordRequest("abcdefgh!1");
        assertFalse(passwordValidator.isValid(passwordRequest));
    }

    @Test
    void shouldReturnFalseWhenPasswordDoesNotContainSpecialCharacter() {
        PasswordRequest passwordRequest = new PasswordRequest("aBcdefgh1");
        assertFalse(passwordValidator.isValid(passwordRequest));
    }

    @Test
    void shouldReturnFalseWhenPasswordContainsRepeatedCharacters() {
        PasswordRequest passwordRequest = new PasswordRequest("aBcdefghh!1");
        assertFalse(passwordValidator.isValid(passwordRequest));
    }

    @Test
    void shouldReturnFalseWhenPasswordContainsSpace() {
        PasswordRequest passwordRequest = new PasswordRequest("aBc defgh!1");
        assertFalse(passwordValidator.isValid(passwordRequest));
    }

    @Test
    void shouldReturnTrueWhenPasswordIsValid() {
        PasswordRequest passwordRequest = new PasswordRequest("ValiDPAsSword1!");
        assertTrue(passwordValidator.isValid(passwordRequest));
    }
}
