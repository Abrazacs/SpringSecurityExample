package ru.sergeysemenov.SpringSecurityExample.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeysemenov.SpringSecurityExample.exceptions.AppError;
import ru.sergeysemenov.SpringSecurityExample.model.dto.JwtAuthenticationResponse;
import ru.sergeysemenov.SpringSecurityExample.model.dto.SignInRequest;
import ru.sergeysemenov.SpringSecurityExample.model.dto.SignUpRequest;
import ru.sergeysemenov.SpringSecurityExample.service.AuthenticationService;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Ошибка регистрации", responseCode = "400",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            })
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @Operation(
            summary = "Запрос на авторизацию",
            responses = {
                    @ApiResponse(
                            description = "Успешный ответ", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = JwtAuthenticationResponse.class))
                    ),
                    @ApiResponse(
                            description = "Отказ в авторизации", responseCode = "401",
                            content = @Content(schema = @Schema(implementation = AppError.class))
                    )
            }
    )
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
