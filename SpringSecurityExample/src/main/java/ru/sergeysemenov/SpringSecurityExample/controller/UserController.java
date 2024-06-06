package ru.sergeysemenov.SpringSecurityExample.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.sergeysemenov.SpringSecurityExample.model.dto.UserDto;
import ru.sergeysemenov.SpringSecurityExample.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    UserService userService;


    @Operation(
            summary = "Запрос на получения списка всех пользователей",
            responses = {
                    @ApiResponse(
                    description = "Успешный ответ", responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))
                    })
            }
    )
    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> getAllUsers() {
       return userService.getAllUsers();
    }

}
