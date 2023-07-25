package com.control.asistencia.adapter.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "persona_rol")
public class PersonaRolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona_rol")
    private int idPersonaRol;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolEntity rol;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ci", nullable = false)
    private PersonaEntity persona;

    public PersonaRolEntity(){

    }
}
