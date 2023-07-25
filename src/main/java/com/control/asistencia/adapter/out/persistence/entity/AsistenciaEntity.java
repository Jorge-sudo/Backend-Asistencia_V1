package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "asistencia")
public class AsistenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private int idAsistencia;

    @Column(name = "hora_entrada", nullable = false)
    private Time horaEntrada;
    //@Digits(integer=3, fraction=0, message="No se permite decimales y maximo de digitos es 3.")
    @Column(name = "cant_estudiantes", nullable = true)
    private Integer cantidadEstudiantes;

    @Column(nullable = false)
    private Date fecha;
    @Size(min=2, max=20, message="el tamaño tiene que estar entre 2 y 20")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false)
    private String estado;

    @Size(min=2, max=20, message="el tamaño tiene que estar entre 2 y 20")
    @NotEmpty(message ="no puede estar vacio")
    @Column(nullable = false, name = "id_modulo")
    private String idModulo;

    //@Size(min=2, max=25, message="el tamaño tiene que estar entre 2 y 20")
    //@NotEmpty(message ="no puede estar vacio")
    @Column(nullable = true)
    private String horario;

    public AsistenciaEntity(){

    }

    public AsistenciaEntity(Time horaEntrada, Date fecha) {
        this.horaEntrada = horaEntrada;
        this.fecha = fecha;
    }
}
