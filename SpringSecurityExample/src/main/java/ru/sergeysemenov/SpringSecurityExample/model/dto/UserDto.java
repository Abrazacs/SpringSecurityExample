package ru.sergeysemenov.SpringSecurityExample.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.sergeysemenov.SpringSecurityExample.model.User;

public class UserDto {

    public UserDto (User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
    }

    @Schema(description = "логин пользователя", required = true)
    private String username;

    @Schema(description = "email", required = true, example = "mail@mail.com")
    private String email;


}
