package com.itaubackendchallenge.passwordvalidator.controller;

import com.itaubackendchallenge.passwordvalidator.exception.PasswordInvalidException;
import com.itaubackendchallenge.passwordvalidator.model.PasswordRequest;
import com.itaubackendchallenge.passwordvalidator.service.PasswordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Password Validator API", description = "API to validate passwords.")

@RestController
@RequestMapping("v01/password-validations")
@RequiredArgsConstructor
public class PasswordController {
    private final PasswordService passwordService;

    @Operation(
            summary = "Validates a password",
            description = "This endpoint receives a password for validation.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PasswordRequest.class, example = "{\"password\": \"ValiDPAsSword1!\"}"))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Boolean.class, example = "true"))),

                    @ApiResponse(responseCode = "400", description = "Bad Request",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Boolean.class, example = "false"))),
            })
    @PostMapping
    public ResponseEntity<Boolean> validatePassword(@RequestBody PasswordRequest password) {
        return ResponseEntity.ok(passwordService.validate(password));
    }
}
