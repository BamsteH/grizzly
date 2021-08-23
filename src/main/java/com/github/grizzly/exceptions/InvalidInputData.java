package com.github.grizzly.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid input data")
public class InvalidInputData extends RuntimeException {

    public InvalidInputData() {
    }

    public InvalidInputData(String message) {
        super(message);
    }

    public InvalidInputData(Throwable cause) {
        super(cause);
    }
}
