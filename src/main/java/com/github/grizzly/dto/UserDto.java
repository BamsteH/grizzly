package com.github.grizzly.dto;

public class UserDto {

    public static final String ALPHANUMERIC = "^[a-zA-Z0-9]+$";

    public static final String EMAIL_REGEX = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]+$";

    public static final String USER_PHONE_REGEX = "^\\+[1-9][0-9]?[\\s]*\\(?\\d{3}\\)?[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}$";

    public static final String USER_ADDRESS_REGEX = "^[^#$%^*()']*$";

}
