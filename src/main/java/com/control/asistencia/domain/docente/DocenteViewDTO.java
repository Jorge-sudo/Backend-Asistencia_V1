package com.control.asistencia.domain.docente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteViewDTO {
    private long ci;
    private String nombre;
    private String apellido;
    private String fotografia;
    private String email;
    private String genero;
    private String correoInstitucional;
    private boolean activo;
    private String rol;
    private String codRfid;
}
