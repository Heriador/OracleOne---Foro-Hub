package com.OracleOne.ForoHub.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearRespuesta {

    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(min = 5, max = 500, message = "El mensaje debe tener entre 5 y 500 caracteres")
    private String mensaje;

    @Positive(message = "El id del topico debe ser un número positivo")
    private Long topicoId;
}
