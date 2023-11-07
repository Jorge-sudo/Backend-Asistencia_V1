package com.control.asistencia.domain.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "El email no puede estar vacío")
    @NotNull(message = "El email no puede ser nulo")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @NotNull(message = "La contraseña no puede ser nula")
    @Length(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String contrasenia;
}
