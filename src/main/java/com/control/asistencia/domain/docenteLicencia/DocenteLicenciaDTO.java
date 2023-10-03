package com.control.asistencia.domain.docenteLicencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteLicenciaDTO {
    private int idDocenteLicencia;
    private Date fechaInicio;
    private Date fechaFinal;
    private String descripcion;
    private Long ciDocente;
    private String nombreDocente;
    private String apellidoDocente;
    private String base64Image;
}
