package com.control.asistencia.adapter.out.persistence.entity.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardView {
    @Id
    private Integer id;
    private Long materias;
    private Long materiasActivas;
    private Long docentes;
    private Long docentesActivos;
    private Long asistenciasHoy;
    private Long asistenciasPuntualesHoy;
    private Long asistenciasMes;
    private Long asistenciasPuntualesMes;
}
