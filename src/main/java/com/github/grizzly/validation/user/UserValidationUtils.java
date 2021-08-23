package com.github.grizzly.validation.user;

import java.util.regex.Pattern;

public class UserValidationUtils {

    private static final String EMAIL_PATTERN =
            "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
                    "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*" +
                    "|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]" +
                    "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9]" +
                    "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?" +
                    "|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}" +
                    "(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:" +
                    "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]" +
                    "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    private static final String LOGIN_PATTERN =
            "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.-]{0,19}$";

    private static final String NAME_PATTERN =
            "^[A-Za-z\\x{00C0}-\\x{00FF}][A-Za-z\\x{00C0}-\\x{00FF}\\'\\-]+([\\ A-Za-z\\x{00C0}-\\x{00FF}][A-Za-z\\x{00C0}-\\x{00FF}\\'\\-]+)*/u";

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,16}$";

    private static final String PHONE_PATTERN =
            "/\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})/";

    private static boolean isValidValue(String value, Pattern pattern) {
        return pattern.matcher(value).matches();
    }

    public static boolean isValidEmail(String email) {
        return isValidValue(email, Pattern.compile(EMAIL_PATTERN));
    }

    public static boolean isValidLogin(String login) {
        return isValidValue(login, Pattern.compile(LOGIN_PATTERN));
    }

    public static boolean isValidName(String name) {
        return isValidValue(name, Pattern.compile(NAME_PATTERN));
    }

    public static boolean isValidPassword(String password) {
        return isValidValue(password, Pattern.compile(PASSWORD_PATTERN));
    }

    public static boolean isValidPhone(String phone) {
        return isValidValue(phone, Pattern.compile(PHONE_PATTERN));
    }

}
