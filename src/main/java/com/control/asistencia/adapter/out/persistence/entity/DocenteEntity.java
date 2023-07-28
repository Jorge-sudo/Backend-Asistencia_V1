package com.control.asistencia.adapter.out.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true) // Agrega esta línea para elegir si incluir o no los campos de la superclase.
@PrimaryKeyJoinColumn(name="ci")
@Table(name = "docente")
@AllArgsConstructor
@NoArgsConstructor
public class DocenteEntity extends PersonaEntity{

    @Id
    @Digits(integer=10, fraction=0, message="No se permite decimales y maximo de digitos es 10.")
    private long ci;
    @Size(min=2, max=20, message="el tamaño tiene que estar entre 2 y 20")
    @Column(name = "cod_rfid", nullable = false, unique = true)
    private String codRfid;
    /*@JsonManagedReference  se utiliza en la entidad padre para indicar que la relacion es administrada
     o manejada por esa entidad si no se hace esto habra un ciclo infinito y un desborde de memoria*/

    public DocenteEntity(long ci){
        this.ci = ci;
    }

}
