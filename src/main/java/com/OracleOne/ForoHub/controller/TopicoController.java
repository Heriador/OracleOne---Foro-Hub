package com.OracleOne.ForoHub.controller;

import com.OracleOne.ForoHub.domain.dto.request.CrearTopico;
import com.OracleOne.ForoHub.domain.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<CrearTopico> crearTopico(@RequestBody @Valid CrearTopico crearTopico){
        topicoService.crearTopico(crearTopico);
        return ResponseEntity.ok(crearTopico);

    }

}
