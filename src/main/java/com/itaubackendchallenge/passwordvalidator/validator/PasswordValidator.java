package com.itaubackendchallenge.passwordvalidator.validator;

import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PasswordValidator {

    public boolean isValid(PasswordRequest password) {


        if (password == null || password.getPassword() == null) {
            return false;
        }

        String passwordValue = password.getPassword();

        if (!passwordValue.matches(".{9,}")) {
            return false;
        }
        if (!passwordValue.matches(".*\\d.*")) {
            return false;
        }
        if (!passwordValue.matches(".*[a-z].*")) {
            return false;
        }
        if (!passwordValue.matches(".*[A-Z].*")) {
            return false;
        }
        if (!passwordValue.matches(".*[!@#$%^&*()-+].*")) {
            return false;
        }
        if (passwordValue.matches(".*(.)(.*\\1).*")) {
            return false;
        }
        if (passwordValue.contains(" ")) {
            return false;
        }
        return true;
    }
}
