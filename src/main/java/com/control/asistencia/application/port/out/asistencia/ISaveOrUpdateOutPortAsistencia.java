package com.control.asistencia.application.port.out.asistencia;

import com.control.asistencia.application.port.in.asistencia.command.CommandAsistencia;
import com.control.asistencia.domain.mqttAsistencia.MqttMessageResponseNumberEstudiante;

import java.util.Optional;

public interface ISaveOrUpdateOutPortAsistencia {
    Optional<CommandAsistencia> saveOrUpdateAsistencia(CommandAsistencia commandAsistencia);
    boolean updateMqttNumberStudentAsistencia(MqttMessageResponseNumberEstudiante message);
}
