package com.OracleOne.ForoHub.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Login {

        @Email(message = "El email debe ser valido")
        private String email;

        @NotBlank(message = "La contraseña no puede estar vacia")
        private String password;
}
