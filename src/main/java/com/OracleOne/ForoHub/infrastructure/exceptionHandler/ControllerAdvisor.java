package com.OracleOne.ForoHub.infrastructure.exceptionHandler;

import com.OracleOne.ForoHub.domain.exceptions.RespuestaNotFoundException;
import com.OracleOne.ForoHub.domain.exceptions.TopicoAlreadyExistsException;
import com.OracleOne.ForoHub.domain.exceptions.TopicoNotFoundException;
import com.OracleOne.ForoHub.domain.exceptions.UsuarioAlreadyExistsException;
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
}
