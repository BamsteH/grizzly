package com.github.grizzly.controller;

import com.github.grizzly.dto.UserRegDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/reg")
public interface IRegistrationController {

    @PostMapping("/")
    ModelAndView register(@ModelAttribute("user") @Valid UserRegDto regDto);

}
