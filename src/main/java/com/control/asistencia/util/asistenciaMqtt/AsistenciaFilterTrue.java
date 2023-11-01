package com.control.asistencia.util.asistenciaMqtt;

import com.control.asistencia.adapter.out.persistence.entity.CarreraEntity;
import com.control.asistencia.adapter.out.persistence.entity.DiaSemanaEntity;
import com.control.asistencia.adapter.out.persistence.entity.SemestreEntity;
import com.control.asistencia.adapter.out.persistence.entity.TurnoEntity;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryCarrera;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryDiaSemana;
import com.control.asistencia.adapter.out.persistence.repository.IRepositorySemestre;
import com.control.asistencia.adapter.out.persistence.repository.IRepositoryTurno;
import com.control.asistencia.application.port.in.asignatura.command.CommandPageAssignMateria;
import com.control.asistencia.config.exception.exceptions.DataNotFoundExceptionMessage;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Data
public class AsistenciaFilterTrue {
    private final IRepositoryCarrera iRepositoryCarrera;
    private final IRepositoryTurno iRepositoryTurno;
    private final IRepositorySemestre iRepositorySemestre;
    private final IRepositoryDiaSemana iRepositoryDiaSemana;
    private CarreraEntity carrera;
    private TurnoEntity turno;
    private SemestreEntity semestre;
    private DiaSemanaEntity dia;

    public AsistenciaFilterTrue(
            IRepositoryCarrera iRepositoryCarrera,
            IRepositoryTurno iRepositoryTurno,
            IRepositorySemestre iRepositorySemestre,
            IRepositoryDiaSemana iRepositoryDiaSemana) {
        this.iRepositoryCarrera = iRepositoryCarrera;
        this.iRepositoryTurno = iRepositoryTurno;
        this.iRepositorySemestre = iRepositorySemestre;
        this.iRepositoryDiaSemana = iRepositoryDiaSemana;
    }

    public boolean isPresent(CommandPageAssignMateria command){
        Optional<CarreraEntity> carrera = Optional.ofNullable(
                this.iRepositoryCarrera.findById(command.getIdCarrera()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró la carrera con el id: " + command.getIdCarrera()
                        )
                ));
        Optional<TurnoEntity> turno = Optional.ofNullable(
                this.iRepositoryTurno.findById(command.getIdTurno()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró el turno con el id: " + command.getIdTurno() )
                )
        );
        Optional<SemestreEntity> semestre = Optional.ofNullable(
                this.iRepositorySemestre.findById(command.getIdSemestre()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró el semestre con el id: " + command.getIdSemestre() )
                )
        );
        Optional<DiaSemanaEntity> dia = Optional.ofNullable(
                this.iRepositoryDiaSemana.findById(command.getIdDia()).orElseThrow(
                        () -> new DataNotFoundExceptionMessage("No se encontró el día con el id: " + command.getIdDia() )
                )
        );
        carrera.ifPresent(value -> this.carrera = value);
        turno.ifPresent(value -> this.turno = value);
        semestre.ifPresent(value -> this.semestre = value);
        dia.ifPresent(value -> this.dia = value);

        return carrera.isPresent() && turno.isPresent() && semestre.isPresent() && dia.isPresent();

    }


}
