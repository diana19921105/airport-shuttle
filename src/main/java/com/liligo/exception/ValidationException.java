package com.liligo.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

    private final String[] args;

    public ValidationException(String message, String... args) {
        super(message);
        this.args = args;
    }

}
