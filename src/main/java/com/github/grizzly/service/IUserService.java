package com.github.grizzly.service;

import com.github.grizzly.dto.UserAuthDto;
import com.github.grizzly.dto.UserRegDto;
import com.github.grizzly.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    User findById(Long id);

    User findByLogin(String login);

    User findByEmail(String email);

    User create(UserRegDto regDto);

    User authorize(UserAuthDto authDto);

    User authorizeViaEmail(UserAuthDto authDto);

    User authorizeViaLogin(UserAuthDto authDto);

    User authorizeViaPhone(UserAuthDto authDto);

    User verify(User user);

}
