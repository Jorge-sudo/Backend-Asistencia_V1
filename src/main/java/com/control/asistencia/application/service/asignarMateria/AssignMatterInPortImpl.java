package com.control.asistencia.application.service.asignarMateria;

import com.control.asistencia.adapter.in.web.utilController.ResponseBuilderApiRest;
import com.control.asistencia.application.port.in.asignarMateria.IAssignMatterInPort;
import com.control.asistencia.application.port.in.asignarMateria.command.CommandAssignMatter;
import com.control.asistencia.application.port.in.asignarMateria.command.CommandMateriaDocente;
import com.control.asistencia.application.port.out.aulaMateriaDocente.ISaveOrUpdateOutPortAulaMateriaDocente;
import com.control.asistencia.application.port.out.horarioMateriaDocente.ISaveOrUpdateOutPortHorarioMateriaDocente;
import com.control.asistencia.application.port.out.materiaDocente.ISaveOrUpdateOutPortMateriaDocente;
import com.control.asistencia.common.UseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@UseCase
public class AssignMatterInPortImpl implements IAssignMatterInPort {
    private final ISaveOrUpdateOutPortMateriaDocente iSaveOrUpdateOutPortMateriaDocente;
    private final ISaveOrUpdateOutPortHorarioMateriaDocente iSaveOrUpdateOutPortHorarioMateriaDocente;
    private final ISaveOrUpdateOutPortAulaMateriaDocente iSaveOrUpdateOutPortAulaMateriaDocente;
    public AssignMatterInPortImpl (
            ISaveOrUpdateOutPortMateriaDocente iSaveOrUpdateOutPortMateriaDocente,
            ISaveOrUpdateOutPortHorarioMateriaDocente iSaveOrUpdateOutPortHorarioMateriaDocente,
            ISaveOrUpdateOutPortAulaMateriaDocente iSaveOrUpdateOutPortAulaMateriaDocente) {

        this.iSaveOrUpdateOutPortMateriaDocente = iSaveOrUpdateOutPortMateriaDocente;
        this.iSaveOrUpdateOutPortHorarioMateriaDocente = iSaveOrUpdateOutPortHorarioMateriaDocente;
        this.iSaveOrUpdateOutPortAulaMateriaDocente = iSaveOrUpdateOutPortAulaMateriaDocente;
    }
    @Override
    @Transactional
    public ResponseEntity<?> assignMatter(CommandAssignMatter command) {
        CommandMateriaDocente materiaDocente = this.iSaveOrUpdateOutPortMateriaDocente
                .saveOrUpdateMateriaDocente(command.getMateriaDocente()).orElse(null);

        assert materiaDocente != null;

        command.getHorarioMateriaDocentes().forEach(horarioMateriaDocente -> horarioMateriaDocente.setIdMateriaDocente(materiaDocente.getIdMateriaDocente()));

        command.getAulaMateriaDocente().setIdMateriaDocente(materiaDocente.getIdMateriaDocente());

        return ResponseBuilderApiRest.save(
                Optional.of(
                        CommandAssignMatter.builder()
                                .horarioMateriaDocentes(
                                        this.iSaveOrUpdateOutPortHorarioMateriaDocente
                                                .saveOrUpdateHorarioMateriaDocente(
                                                        command.getHorarioMateriaDocentes()
                                                )
                                )
                                .aulaMateriaDocente(
                                        this.iSaveOrUpdateOutPortAulaMateriaDocente
                                                .saveOrUpdateAulaMateriaDocente(
                                                        command.getAulaMateriaDocente()
                                                ).orElse(null)
                                )
                                .materiaDocente(
                                        materiaDocente
                                )
                                .build()
                )
        );
    }
}
