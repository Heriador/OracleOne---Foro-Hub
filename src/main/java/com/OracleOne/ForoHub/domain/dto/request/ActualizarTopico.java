package com.OracleOne.ForoHub.domain.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActualizarTopico {

    @Size(min = 5, max = 100, message = "El titulo debe tener entre 5 y 100 caracteres")
    private String titulo;

    @Size(min = 5, max = 1000, message = "El mensaje debe tener entre 5 y 1000 caracteres")
    private String mensaje;
}
