package com.github.grizzly.controller;

import com.github.grizzly.dto.UserAuthDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public interface IAuthorizationController {

    @PostMapping("/")
    ResponseEntity<Object> authorize(@RequestBody UserAuthDto authDto);

}
