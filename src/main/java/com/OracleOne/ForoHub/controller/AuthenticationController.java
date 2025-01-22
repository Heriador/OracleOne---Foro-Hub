package com.OracleOne.ForoHub.controller;

import com.OracleOne.ForoHub.domain.dto.request.CrearUsuario;
import com.OracleOne.ForoHub.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class AuthenticationController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public void registrarUsuario(@RequestBody @Valid CrearUsuario crearUsuario) {
        usuarioService.crearUsuario(crearUsuario);
    }

}
