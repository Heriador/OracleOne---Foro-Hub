package com.OracleOne.ForoHub.infrastructure.security;

import com.OracleOne.ForoHub.domain.entity.CustomUserDetails;
import com.OracleOne.ForoHub.domain.exceptions.AuthenticationException;
import com.OracleOne.ForoHub.domain.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new AuthenticationException("Usuario no encontrado"));
    }
}
