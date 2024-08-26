package com.liligo.exception;

import lombok.Getter;

@Getter
public class NotModifyAbleException extends RuntimeException {

    private final String[] args;

    public NotModifyAbleException(String message, String... args) {
        super(message);
        this.args = args;
    }

}
