package com.control.asistencia.adapter.out.persistence.entity;


import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@EqualsAndHashCode(callSuper = true) // Agrega esta línea para elegir si incluir o no los campos de la superclase.
@PrimaryKeyJoinColumn(name="ci")
@Table(name = "docente")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DocenteEntity extends PersonaEntity{

    @Id
    @Digits(integer=12, fraction=0, message="CI docente no valido: No se permite decimales y maximo de digitos es 12.")
    private long ci;

    @Size(min=2, max=20, message="el tamaño tiene que estar entre 2 y 20")
    @NotBlank(message = "CodRfid no válido: codRfid vacío")
    @NotNull(message ="CodRfid no valido: el codRfid es NULL")
    @Column(name = "cod_rfid", unique = true)
    private String codRfid;
    /*@JsonManagedReference  se utiliza en la entidad padre para indicar que la relacion es administrada
     o manejada por esa entidad si no se hace esto habra un ciclo infinito y un desborde de memoria*/
}
