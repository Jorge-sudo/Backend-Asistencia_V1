package com.control.asistencia.adapter.out.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "docente_licencia")
public class DocenteLicenciaEntity {
    @Id
    @Column(name = "id_docente_licencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocenteLicencia;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_licencia", nullable = false)
    private LicenciaEntity licencia;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ci", nullable = false)
    private DocenteEntity docente;

    public DocenteLicenciaEntity(){

    }

}
