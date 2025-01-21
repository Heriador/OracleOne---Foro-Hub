package com.OracleOne.ForoHub.infrastructure.exceptionHandler;

import com.OracleOne.ForoHub.domain.exceptions.TopicoAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(TopicoAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleTopicoAlreadyExistsException(TopicoAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message",e.getMessage()));
    }
}
