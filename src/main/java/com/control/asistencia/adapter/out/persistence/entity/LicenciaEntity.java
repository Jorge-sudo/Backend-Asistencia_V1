package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "licencia")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LicenciaEntity {
    @Id
    @Column(name = "id_licencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLicencia;

    @Future(message = "La fecha de inicio debe ser futura")
    @NotNull(message = "Fecha Inicio  no válido: la Fecha Inicio es NULL")
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Future(message = "La fecha de final debe ser futura")
    @NotNull(message = "Fecha Final no válido: la Fecha Final es NULL")
    @Column(name = "fecha_final", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    @Size(min=2, max=1000, message="Descripción no válido: el tamaño tiene que estar entre 2 y 1000")
    @NotBlank(message = "Descripción no válido: Descripción vacío")
    @NotNull(message = "Descripción no válido: la Descripción es NULL")
    @Column(nullable = false)
    private String descripcion;
}
