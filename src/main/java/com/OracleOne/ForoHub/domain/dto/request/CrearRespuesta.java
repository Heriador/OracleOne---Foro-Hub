package com.OracleOne.ForoHub.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearRespuesta {

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    @Positive(message = "El id del topico debe ser un número positivo")
    private Long topicoId;
}
