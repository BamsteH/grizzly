package com.github.grizzly.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserAuthDto {

    @NotEmpty(message = "Login cannot be empty")
    private String login;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

}
