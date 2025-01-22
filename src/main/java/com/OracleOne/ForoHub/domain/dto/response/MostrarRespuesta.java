package com.OracleOne.ForoHub.domain.dto.response;

import com.OracleOne.ForoHub.domain.entity.Respuesta;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MostrarRespuesta {

    private Long id;
    private String mensaje;
    private Long topicoId;
    private LocalDateTime fechaCreacion;

    public MostrarRespuesta(Respuesta respuesta){
        this.id = respuesta.getId();
        this.mensaje = respuesta.getMensaje();
        this.topicoId = respuesta.getTopico().getId();
        this.fechaCreacion = respuesta.getCreatedAt();
    }
}
