package com.control.asistencia.application.service.asistencia;

import com.control.asistencia.application.port.in.asistencia.command.CommandAsistenciaForm;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
import com.control.asistencia.application.port.out.aula.IViewOutPortAula;
import com.control.asistencia.application.port.out.docente.IViewOutPortDocente;
import com.control.asistencia.application.port.out.horarioMateriaDocente.IViewOutPortHorarioMateriaDocente;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import com.control.asistencia.domain.horarioMateriaDocente.HorarioMateriaDocenteDTO;
import com.control.asistencia.util.asistenciaMqtt.AsistenciaStatus;
import com.control.asistencia.util.asistenciaMqtt.UtilDia;
import com.control.asistencia.util.controller.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.asistencia.ISaveOrUpdateInPortAsistencia;
import com.control.asistencia.application.port.in.asistencia.command.CommandAsistencia;
import com.control.asistencia.application.port.out.asistencia.ISaveOrUpdateOutPortAsistencia;
import com.control.asistencia.common.UseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.Set;


@UseCase
public class SaveOrUpdateInPortImplAsistencia implements ISaveOrUpdateInPortAsistencia {
    private static final Logger logger = LoggerFactory.getLogger(SaveOrUpdateInPortImplAsistencia.class);
    private final ISaveOrUpdateOutPortAsistencia iSaveOrUpdateOutPortAsistencia;
    private final IViewOutPortDocente iViewOutPortDocente;
    private final IViewOutPortAula iViewOutPortAula;
    private final IViewOutPortHorarioMateriaDocente iViewOutPortHorarioMateriaDocente;
    private final AsistenciaStatus asistenciaStatus;
    private final ZoneId zonaHoraria = ZoneId.of("America/La_Paz");
    private int idHorarioMateriaDocente;
    public SaveOrUpdateInPortImplAsistencia(
            ISaveOrUpdateOutPortAsistencia iSaveOrUpdateOutPortAsistencia,
            IViewOutPortDocente iViewOutPortDocente,
            IViewOutPortAula iViewOutPortAula,
            IViewOutPortHorarioMateriaDocente iViewOutPortHorarioMateriaDocente,
            AsistenciaStatus asistenciaStatus) {

        this.iSaveOrUpdateOutPortAsistencia = iSaveOrUpdateOutPortAsistencia;
        this.iViewOutPortDocente = iViewOutPortDocente;
        this.iViewOutPortAula = iViewOutPortAula;
        this.iViewOutPortHorarioMateriaDocente = iViewOutPortHorarioMateriaDocente;
        this.asistenciaStatus = asistenciaStatus;
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveOrUpdateAsistencia(CommandAsistenciaForm command) {
        Optional<CommandAsistencia> asistencia;
        // Crear objetos java.sql.Date y java.sql.Time a partir de la fecha y hora actuales
        Date date = Date.valueOf(LocalDate.now(this.zonaHoraria));
        Time time = Time.valueOf(LocalTime.now(this.zonaHoraria));

        Optional<DocenteViewDTO> docenteViewDTO = this.iViewOutPortDocente.viewByCiDocenteDTO(command.getCi());

        Optional<CommandAula> commandAula = this.iViewOutPortAula.viewByIdAulaDTO(command.getIdAula());

        if(docenteViewDTO.isPresent() && commandAula.isPresent()) {
            asistencia = this.iSaveOrUpdateOutPortAsistencia.saveOrUpdateAsistencia(
                    CommandAsistencia.builder()
                            .horaEntrada(time)
                            .cantidadEstudiantes(command.getCantidadEstudiantes())
                            .fecha(date)
                            .estado(
                                    this.getStatusAssistant(
                                            docenteViewDTO.get().getCi(),
                                            UtilDia.getDiaSemana(date),
                                            time
                                    )
                            )
                            .idAula(commandAula.get().getId())
                            .idHorarioMateriaDocente(this.idHorarioMateriaDocente)
                            .build()
            );
        }else{
            logger.error("Docente o Aula no encontrados");
            throw new RuntimeException("Docente o Aula no encontrados");
        }
        return ResponseBuilderApiRest.save(asistencia);
    }

    private String getStatusAssistant(Long ci, String dia, Time time){
        Set<HorarioMateriaDocenteDTO> horarios =
                this.iViewOutPortHorarioMateriaDocente.viewByDocenteAndDiaDTO(ci, dia);

        return this.asistenciaStatus.getDocenteLate(horarios, time).map(horario -> {
            logger.info("HorarioMateriaDocentesAtrasado =>" + horario);
            this.idHorarioMateriaDocente = horario.getIdHorarioMateriaDocente();
            return "Impuntual";
        }).orElseGet(() -> this.asistenciaStatus.getDocentePunctual(horarios, time).map(horario -> {
            logger.info("HorarioMateriaDocentesPuntuales =>" + horario);
            this.idHorarioMateriaDocente = horario.getIdHorarioMateriaDocente();
            return "Puntual";
        }).orElse("Fuera de horario"));
    }
}
