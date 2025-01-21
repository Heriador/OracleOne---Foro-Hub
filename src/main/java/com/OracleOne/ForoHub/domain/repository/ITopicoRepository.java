package com.OracleOne.ForoHub.domain.repository;

import com.OracleOne.ForoHub.domain.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTitulo(String titulo);
}
