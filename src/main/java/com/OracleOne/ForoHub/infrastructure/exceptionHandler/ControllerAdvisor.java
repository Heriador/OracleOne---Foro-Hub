package com.OracleOne.ForoHub.infrastructure.exceptionHandler;

import com.OracleOne.ForoHub.domain.exceptions.RespuestaNotFoundException;
import com.OracleOne.ForoHub.domain.exceptions.TopicoAlreadyExistsException;
import com.OracleOne.ForoHub.domain.exceptions.TopicoNotFoundException;
import com.OracleOne.ForoHub.domain.exceptions.UsuarioAlreadyExistsException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(TopicoAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleTopicoAlreadyExistsException(TopicoAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(TopicoNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleTopicoNotFoundException(TopicoNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(RespuestaNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleRespuestaNotFoundException(RespuestaNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(UsuarioAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleUsuarioAlreadyExistsException(UsuarioAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<Map<String,String>> handleJWTVerificationException(JWTVerificationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message",e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String,Object> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->

                errors.put(error.getField(),error.getDefaultMessage())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message",e.getMessage()));
    }
}
