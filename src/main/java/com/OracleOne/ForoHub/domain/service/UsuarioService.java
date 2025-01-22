package com.OracleOne.ForoHub.domain.service;

import com.OracleOne.ForoHub.domain.dto.request.CrearUsuario;
import com.OracleOne.ForoHub.domain.entity.Usuario;
import com.OracleOne.ForoHub.domain.exceptions.UsuarioAlreadyExistsException;
import com.OracleOne.ForoHub.domain.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public void crearUsuario(CrearUsuario crearUsuario) {

        if(usuarioRepository.existsByUsername(crearUsuario.getUsername()) || usuarioRepository.existsByEmail(crearUsuario.getEmail())) {
            throw new UsuarioAlreadyExistsException("El nombre de usuario o email ya esta registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(crearUsuario.getUsername());
        usuario.setPassword(crearUsuario.getPassword());
        usuario.setEmail(crearUsuario.getEmail());
        usuario.setCreatedAt(LocalDateTime.now());
        usuario.setUpdatedAt(LocalDateTime.now());
        usuarioRepository.save(usuario);

    }

}
