package com.control.asistencia.adapter.out.persistence.entity.view;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@Immutable
public class MateriaAssignView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private Boolean activo;
    private String sigla;
    private String carrera;
    private String aula;
    private String dia;
    private String horario;
    private String turno;
    private Boolean laboratorio;
    private Integer nroLaboratorio;
    private String semestre;
    private String nombreDocente;
    private String apellidoDocente;

}
