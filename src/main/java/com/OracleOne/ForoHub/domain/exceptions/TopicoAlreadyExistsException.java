package com.OracleOne.ForoHub.domain.exceptions;

public class TopicoAlreadyExistsException extends RuntimeException {
    public TopicoAlreadyExistsException(String message) {
        super(message);
    }
}
