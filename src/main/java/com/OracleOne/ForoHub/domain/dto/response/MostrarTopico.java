package com.OracleOne.ForoHub.domain.dto.response;

import com.OracleOne.ForoHub.domain.entity.Topico;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MostrarTopico {

    @NotNull
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensaje;

    @Temporal(TemporalType.DATE)
    private LocalDateTime createdAt;

    @NotBlank
    private String status;

    @NotBlank
    private String curso;

    public MostrarTopico(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensaje = topico.getMensaje();
        this.createdAt = topico.getCreatedAt();
        this.status = topico.getStatus();
        this.curso = topico.getCurso();
    }

}
