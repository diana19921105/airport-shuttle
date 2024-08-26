package com.liligo.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private final String[] args;

    public NotFoundException(String message, String... args) {
        super(message);
        this.args = args;
    }

}
