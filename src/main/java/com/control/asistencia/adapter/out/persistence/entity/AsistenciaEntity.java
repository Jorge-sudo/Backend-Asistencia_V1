package com.control.asistencia.adapter.out.persistence.entity;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "asistencia")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsistenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private int idAsistencia;

    @NotBlank(message = "Hora entrada no válido: Hora entrada vacío")
    @NotNull(message = "Hora entrada no válido: la Hora entrada es NULL")
    @Column(name = "hora_entrada", nullable = false)
    private Time horaEntrada;
    //@Digits(integer=3, fraction=0, message="No se permite decimales y maximo de digitos es 3.")
    @Column(name = "cant_estudiantes", nullable = true)
    private Integer cantidadEstudiantes;

    @NotBlank(message = "Fecha entrada no válido: Fecha vacío")
    @NotNull(message = "Fecha entrada no válido: la Fecha es NULL")
    private Date fecha;

    @Size(min=2, max=20, message="Estado entrada no válido: el tamaño tiene que estar entre 2 y 20")
    @NotBlank(message = "Estado entrada no válido: estado vacío")
    @NotNull(message = "Estado entrada no válido: la estado es NULL")
    private String estado;

    @Size(min=2, max=20, message="IdModulo entrada no válido: el tamaño tiene que estar entre 2 y 20")
    @NotBlank(message = "IdModulo entrada no válido: idModulo vacío")
    @NotNull(message = "IdModulo entrada no válido: la idModulo es NULL")
    @Column(name = "id_modulo")
    private String idModulo;

    //@Size(min=2, max=25, message="el tamaño tiene que estar entre 2 y 20")
    //@NotEmpty(message ="no puede estar vacio")
    @Nullable
    private String horario;

}
