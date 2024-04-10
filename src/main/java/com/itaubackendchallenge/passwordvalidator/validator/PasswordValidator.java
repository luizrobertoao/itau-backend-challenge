package com.itaubackendchallenge.passwordvalidator.validator;

import com.itaubackendchallenge.passwordvalidator.model.Password;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PasswordValidator {

    public boolean isValid(Password password) {

        String passwordValue = password.getValue();

        if (passwordValue.length() < 9) {
            return false;
        }
        if (!hasDigit(passwordValue)) {
            return false;
        }
        if (!hasLowerCase(passwordValue)) {
            return false;
        }
        if (!hasUpperCase(passwordValue)) {
            return false;
        }
        if (!hasSpecialCharacter(passwordValue)) {
            return false;
        }
        if (hasRepeatedCharacters(passwordValue)) {
            return false;
        }
        if (passwordValue.contains(" ")) {
            return false;
        }
        return true;
    }

    private boolean hasDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialCharacter(String str) {
        String specialCharacters = "!@#$%^&*()-+";
        for (char c : str.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasRepeatedCharacters(String str) {
        Set<Character> seen = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!seen.add(c)) {
                return true;
            }
        }
        return false;
    }

}
