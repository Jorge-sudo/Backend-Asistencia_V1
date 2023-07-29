package com.control.asistencia.domain.materia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {
    private String sigla;
    private String nombre;
}
