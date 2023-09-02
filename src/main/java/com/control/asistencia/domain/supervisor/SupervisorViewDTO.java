package com.control.asistencia.domain.supervisor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupervisorViewDTO {
    private long ci;
    private String nombre;
    private String apellido;
    private String fotografia;
    private String base64Image;
    private String email;
    private String genero;
    private String correoInstitucional;
    private boolean activo;
    private String rol;
    private boolean reporteEmail;
    private boolean reporteInstitucional;
}
