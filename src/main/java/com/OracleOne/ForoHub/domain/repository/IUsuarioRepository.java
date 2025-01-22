package com.OracleOne.ForoHub.domain.repository;

import com.OracleOne.ForoHub.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
