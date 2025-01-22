package com.OracleOne.ForoHub.domain.exceptions;

public class UsuarioAlreadyExistsException extends RuntimeException {
  public UsuarioAlreadyExistsException(String message) {
    super(message);
  }
}
