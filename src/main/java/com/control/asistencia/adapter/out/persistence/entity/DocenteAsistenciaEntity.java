package com.control.asistencia.adapter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "docente_asistencia")
@AllArgsConstructor
@NoArgsConstructor
public class DocenteAsistenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente_asistencia")
    private int idDocenteAsistencia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_asistencia", nullable = false)
    private AsistenciaEntity asistencia;
    /* @JsonBackReference se utiliza en la entidad hija para indicar que la relacion es inversa
     * y que no debe ser serializada si no se hace esto habra un ciclo infinito y un desborde de memoria  */

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ci", nullable = false)
    private DocenteEntity docente;


    public DocenteAsistenciaEntity(int idDocenteAsistencia){
        this.idDocenteAsistencia = idDocenteAsistencia;
    }

    public DocenteAsistenciaEntity(AsistenciaEntity asistencia, DocenteEntity docente) {
        this.asistencia = asistencia;
        this.docente = docente;
    }


}
