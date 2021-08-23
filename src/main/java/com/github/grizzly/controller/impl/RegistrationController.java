package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.IRegistrationController;
import com.github.grizzly.dto.UserRegDto;
import com.github.grizzly.entity.User;
import com.github.grizzly.service.IUserService;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

public class RegistrationController implements IRegistrationController {

    private final IUserService userService;

    public RegistrationController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public ModelAndView register(@Valid UserRegDto regDto) {
        User user = userService.create(regDto);
        return null;
    }

}
