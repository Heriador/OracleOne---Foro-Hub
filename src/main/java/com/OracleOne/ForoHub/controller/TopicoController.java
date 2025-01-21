package com.OracleOne.ForoHub.controller;

import com.OracleOne.ForoHub.domain.dto.request.CrearTopico;
import com.OracleOne.ForoHub.domain.dto.response.MostrarTopico;
import com.OracleOne.ForoHub.domain.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<MostrarTopico>> listarTopicos(){
        List<MostrarTopico> topicoList = topicoService.listarTopicos().stream().map(MostrarTopico::new).toList();
        return ResponseEntity.ok(topicoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MostrarTopico> getTopico(@PathVariable Long id){
        return ResponseEntity.ok(new MostrarTopico(topicoService.getTopico(id)));
    }

}
