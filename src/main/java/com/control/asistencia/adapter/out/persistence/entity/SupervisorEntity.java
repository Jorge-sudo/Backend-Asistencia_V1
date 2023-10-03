package com.control.asistencia.adapter.out.persistence.entity;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true) // Agrega esta línea para elegir si incluir o no los campos de la superclase.
@PrimaryKeyJoinColumn(name="ci")
@Table(name = "supervisor")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SupervisorEntity extends PersonaEntity{

    @Id
    @Digits(integer=12, fraction=0, message="CI supervisor no valido: No se permite decimales y maximo de digitos es 12.")
    private Long ci;

    @Column(name = "reporte_email", nullable = false)
    private boolean reporteEmail;

    @Column(name = "reporte_institucional",nullable = false)
    private boolean reporteInstitucional;

}
