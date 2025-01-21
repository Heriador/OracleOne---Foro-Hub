package com.OracleOne.ForoHub.controller;

import com.OracleOne.ForoHub.domain.dto.request.CrearRespuesta;
import com.OracleOne.ForoHub.domain.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    public ResponseEntity<CrearRespuesta> crearRespuesta(@RequestBody @Valid CrearRespuesta crearRespuesta) {
        respuestaService.crearRespuesta(crearRespuesta);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(crearRespuesta);
    }
}
