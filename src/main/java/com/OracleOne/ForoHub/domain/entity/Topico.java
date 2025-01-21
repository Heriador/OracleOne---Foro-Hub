package com.OracleOne.ForoHub.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="topicos")
@Data
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique = true)
    private String titulo;

    @Column
    private String mensaje;

    @Column
    private LocalDateTime createdAt;

    @Column
    private String status;

    @Column
    private String curso;


}
