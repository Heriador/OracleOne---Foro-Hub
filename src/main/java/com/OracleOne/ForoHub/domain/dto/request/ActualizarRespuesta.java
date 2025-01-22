package com.OracleOne.ForoHub.domain.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActualizarRespuesta {

    @Size(min = 5, max = 500, message = "El mensaje debe tener entre 5 y 500 caracteres")
    private String mensaje;
}
