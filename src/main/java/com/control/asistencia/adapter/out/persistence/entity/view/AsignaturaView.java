package com.control.asistencia.adapter.out.persistence.entity.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Immutable
public class AsignaturaView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String materia;
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
    @JsonIgnore
    private String fotografiaDocente;
    @Transient
    private String base64Image;
}

