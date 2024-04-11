package com.itaubackendchallenge.passwordvalidator.unit;

import com.itaubackendchallenge.passwordvalidator.controller.PasswordController;
import com.itaubackendchallenge.passwordvalidator.exception.PasswordInvalidException;
import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import com.itaubackendchallenge.passwordvalidator.service.PasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PasswordControllerTest {

    @InjectMocks
    private PasswordController passwordController;

    @Mock
    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnTrueWhenPasswordIsValid() {
        PasswordRequest passwordRequest = new PasswordRequest("ValidPsword1!");
        when(passwordService.validate(passwordRequest)).thenReturn(true);

        ResponseEntity<Boolean> response = passwordController.validatePassword(passwordRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());
    }

//TODO: Implement teste to invalid password

//    @Test
//    void shouldReturnFalseWhenPasswordIsInvalid() {
//        PasswordRequest passwordRequest = new PasswordRequest("invalid");
//        when(passwordService.validate(passwordRequest)).thenReturn(false);
//
//        ResponseEntity<Boolean> response = passwordController.validatePassword(passwordRequest);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals(false, response.getBody());
//    }
}
