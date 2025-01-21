package com.OracleOne.ForoHub.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CrearTopico {


    @NotBlank(message = "El titulo no puede estar vacio")
    @Size(min = 5, max = 100, message = "El titulo debe tener entre 5 y 100 caracteres")
    private String titulo;

    @NotBlank(message = "El mensaje no puede estar vacio")
    @Size(min = 5, max = 1000, message = "El mensaje debe tener entre 5 y 1000 caracteres")
    private String mensaje;

    @NotBlank(message = "El curso no puede estar vacio")
    private String curso;

}
