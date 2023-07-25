package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

@Entity
@Data
@EqualsAndHashCode(callSuper = true) // Agrega esta línea para elegir si incluir o no los campos de la superclase.
@PrimaryKeyJoinColumn(name="ci")
@Table(name = "supervisor")
public class SupervisorEntity extends PersonaEntity{

    @Id
    @Digits(integer=10, fraction=0, message="No se permite decimales y maximo de digitos es 10.")
    private long ci;

    @Column(name = "reporte_email", nullable = false)
    private boolean reporteEmail;
    @Column(name = "reporte_institucional",nullable = false)
    private boolean reporteInstitucional;

    public SupervisorEntity(){

    }

}
