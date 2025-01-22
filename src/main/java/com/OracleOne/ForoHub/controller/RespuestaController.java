package com.OracleOne.ForoHub.controller;

import com.OracleOne.ForoHub.domain.dto.request.ActualizarRespuesta;
import com.OracleOne.ForoHub.domain.dto.request.CrearRespuesta;
import com.OracleOne.ForoHub.domain.dto.response.MostrarRespuesta;
import com.OracleOne.ForoHub.domain.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping
    public ResponseEntity<CrearRespuesta> crearRespuesta(@RequestBody @Valid CrearRespuesta crearRespuesta) {
        respuestaService.crearRespuesta(crearRespuesta);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(crearRespuesta);
    }

    @GetMapping
    public ResponseEntity<List<MostrarRespuesta>> mostrarRespuestas() {
        List<MostrarRespuesta> mostrarRespuestas = respuestaService.mostrarRespuestas().stream().map(MostrarRespuesta::new).toList();
        return ResponseEntity.ok(mostrarRespuestas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MostrarRespuesta> mostrarRespuesta(@PathVariable Long id) {
        return ResponseEntity.ok(new MostrarRespuesta(respuestaService.mostrarRespuesta(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MostrarRespuesta> actualizarRespuesta(@PathVariable Long id, @RequestBody @Valid ActualizarRespuesta actualizarRespuesta) {

        return ResponseEntity.ok(new MostrarRespuesta(respuestaService.actualizarRespuesta(id, actualizarRespuesta)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarRespuesta(@PathVariable Long id) {
        respuestaService.borrarRespuesta(id);
        return ResponseEntity.noContent().build();
    }
}
