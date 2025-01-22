package com.OracleOne.ForoHub.controller;

import com.OracleOne.ForoHub.domain.dto.request.CrearUsuario;
import com.OracleOne.ForoHub.domain.dto.request.Login;
import com.OracleOne.ForoHub.domain.dto.response.LoginResponse;
import com.OracleOne.ForoHub.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid Login login){

        LoginResponse response = new LoginResponse();
        response.setJwt(usuarioService.login(login));

        return ResponseEntity.ok(response);
    }

}
