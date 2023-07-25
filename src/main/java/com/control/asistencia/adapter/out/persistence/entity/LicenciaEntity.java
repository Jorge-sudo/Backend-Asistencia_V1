package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@Table(name = "licencia")
public class LicenciaEntity {
    @Id
    @Column(name = "id_licencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLicencia;

    @Future(message = "La fecha de inicio debe ser futura")
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Future(message = "La fecha de final debe ser futura")
    @Column(name = "fecha_final", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    @Size(min=2, max=1000, message="el tamaño tiene que estar entre 2 y 1000")
    @Column(nullable = false)
    private String descripcion;

    public LicenciaEntity(){

    }
}
