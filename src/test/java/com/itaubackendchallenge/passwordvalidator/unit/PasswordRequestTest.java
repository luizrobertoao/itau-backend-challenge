package com.itaubackendchallenge.passwordvalidator.unit;

import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PasswordRequestTest {

    @Test
    void shouldSetAndGetPassword() {
        PasswordRequest passwordRequest = new PasswordRequest();
        passwordRequest.setPassword("password");

        assertEquals("password", passwordRequest.getPassword());
    }

    @Test
    void shouldConstructWithNoArgsAndHaveNullPassword() {
        PasswordRequest passwordRequest = new PasswordRequest();

        assertNull(passwordRequest.getPassword());
    }

    @Test
    void shouldConstructWithString() {
        PasswordRequest passwordRequest = new PasswordRequest("password");

        assertEquals("password", passwordRequest.getPassword());
    }
}
