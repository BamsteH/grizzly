package com.github.grizzly.dto;

import com.github.grizzly.annotations.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class UserRegDto {

    @ValidName
    @NotEmpty(message = "Firstname is required")
    private String firstName;

    @ValidName
    @NotEmpty(message = "Lastname is required")
    private String lastName;

    @ValidLogin
    @NotEmpty(message = "Login is required")
    private String login;

    @ValidPassword
    @NotEmpty(message = "Password is required")
    private String password;

    @ValidEmail(message = "Should have email format")
    @NotBlank(message = "Email is required")
    private String email;

    @ValidPhone
    @NotEmpty(message = "Phone is required")
    private String phone;

}
