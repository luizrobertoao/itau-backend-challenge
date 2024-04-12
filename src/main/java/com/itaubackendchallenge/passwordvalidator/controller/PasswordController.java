package com.itaubackendchallenge.passwordvalidator.controller;

import com.itaubackendchallenge.passwordvalidator.exception.PasswordInvalidException;
import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import com.itaubackendchallenge.passwordvalidator.service.PasswordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v01/password-validations")
@RequiredArgsConstructor
public class PasswordController {
    private final PasswordService passwordService;

    @Operation(summary = "Validates a password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns true if the password is valid"),
            @ApiResponse(responseCode = "400", description = "Returns false if the password is invalid",
                    content = @Content(schema = @Schema(implementation = Boolean.class, example = "false")))
    })
    @PostMapping
    public ResponseEntity<Boolean> validatePassword(@RequestBody PasswordRequest password) {
        return ResponseEntity.ok(passwordService.validate(password));
    }
}
