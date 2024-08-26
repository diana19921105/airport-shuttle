package com.liligo.exception;

import lombok.Getter;

@Getter
public class NotEnoughAvailableSeatsException extends RuntimeException {

    private final String[] args;

    public NotEnoughAvailableSeatsException(String message, String... args) {
        super(message);
        this.args = args;
    }

}
