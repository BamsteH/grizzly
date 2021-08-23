package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.IAuthorizationController;
import com.github.grizzly.dto.UserAuthDto;
import com.github.grizzly.entity.User;
import com.github.grizzly.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthorizationController implements IAuthorizationController {

    private final IUserService userService;

    public AuthorizationController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Object> authorize(@RequestBody UserAuthDto authDto) {
        User user = userService.authorize(authDto);
        //TODO: Generate token
        return null;
    }

}
