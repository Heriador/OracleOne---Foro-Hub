package com.OracleOne.ForoHub.domain.service;

import com.OracleOne.ForoHub.domain.dto.request.CrearUsuario;
import com.OracleOne.ForoHub.domain.dto.request.Login;
import com.OracleOne.ForoHub.domain.entity.CustomUserDetails;
import com.OracleOne.ForoHub.domain.entity.Usuario;
import com.OracleOne.ForoHub.domain.exceptions.UsuarioAlreadyExistsException;
import com.OracleOne.ForoHub.domain.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void crearUsuario(CrearUsuario crearUsuario) {

        if(usuarioRepository.existsByUsername(crearUsuario.getUsername()) || usuarioRepository.existsByEmail(crearUsuario.getEmail())) {
            throw new UsuarioAlreadyExistsException("El nombre de usuario o email ya esta registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(crearUsuario.getUsername());
        usuario.setPassword(passwordEncoder.encode(crearUsuario.getPassword()));
        usuario.setEmail(crearUsuario.getEmail());
        usuario.setCreatedAt(LocalDateTime.now());
        usuario.setUpdatedAt(LocalDateTime.now());
        usuarioRepository.save(usuario);

    }

    public String login(Login login) {

        if(!validateCredentials(login.getEmail(), login.getPassword())){
            throw new BadCredentialsException("Credenciales inválidas");
        }

        Usuario usuario = authenticate(login.getEmail(), login.getPassword());

        return generateToken(usuario);

    }

    public Usuario authenticate(String email, String password){
        Authentication authUser = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        CustomUserDetails customUserDetails = (CustomUserDetails) authUser.getPrincipal();


        return customUserDetails.getUsuario();
    }

    public boolean validateCredentials(String email, String password){
        try{

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            return authentication.isAuthenticated();
        }catch (BadCredentialsException e){
            return false;
        }
    }


    public String generateToken(Usuario usuario){
        return jwtService.generateToken(usuario);
    }
}
