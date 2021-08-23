package com.github.grizzly.repository;

import com.github.grizzly.entity.User;

import java.util.List;

public class UserRepositoryMocks {

    public static List<User> users(){
        return List.of(
                user_1(),
                user_2(),
                user_3()
        );
    }

    public static User user_1() {
        return new User(1L,
                "user1_firstName",
                "user1_lastName",
                "user1_login",
                "user1_password",
                "user1_@email.com",
                "user1_phone"
        );
    }

    public static User user_2() {
        return new User(2L,
                "user2_firstName",
                "user2_lastName",
                "user2_login",
                "user2_password",
                "user2_@email.com",
                "user2_phone"
        );
    }

    public static User user_3() {
        return new User(3L,
                "user3_firstName",
                "user3_lastName",
                "user3_login",
                "user3_password",
                "user3_@email.com",
                "user3_phone"
        );
    }

}
