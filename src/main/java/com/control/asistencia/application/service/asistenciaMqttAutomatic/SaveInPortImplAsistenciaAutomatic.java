package com.control.asistencia.application.service.asistenciaMqttAutomatic;

import com.control.asistencia.adapter.out.mqtt.IMqttPubTopicGateway;
import com.control.asistencia.application.port.in.asistencia.command.CommandAsistencia;
import com.control.asistencia.application.port.in.aula.command.CommandAula;
import com.control.asistencia.application.port.out.asistencia.ISaveOrUpdateOutPortAsistencia;
import com.control.asistencia.application.port.out.aula.IViewOutPortAula;
import com.control.asistencia.application.port.out.docente.IViewOutPortDocente;
import com.control.asistencia.application.port.out.horarioMateriaDocente.IViewOutPortHorarioMateriaDocente;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.docente.DocenteViewDTO;
import com.control.asistencia.domain.horarioMateriaDocente.HorarioMateriaDocenteDTO;
import com.control.asistencia.domain.mqttAsistencia.MqttMessageAsistencia;
import com.control.asistencia.domain.mqttAsistencia.MqttMessageResponseAsistencia;
import com.control.asistencia.util.asistenciaMqtt.AsistenciaStatus;
import com.control.asistencia.util.asistenciaMqtt.UtilDia;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.Set;

@UseCase
public class SaveInPortImplAsistenciaAutomatic {

    @Value("${mqtt.materia-respuesta-pub}")
    private String materiaSendLcdTopic;

    @Value("${mqtt.asistencia-respuesta-pub}")
    private String asistenciaResponse;
    private final IMqttPubTopicGateway iMqttPubTopicGateway;
    private final IViewOutPortDocente iViewOutPortDocente;
    private final IViewOutPortAula iViewOutPortAula;
    private final ISaveOrUpdateOutPortAsistencia iSaveOrUpdateOutPortAsistencia;
    private final IViewOutPortHorarioMateriaDocente iViewOutPortHorarioMateriaDocente;
    private final AsistenciaStatus asistenciaStatus;
    private static final Logger logger = LoggerFactory.getLogger(SaveInPortImplAsistenciaAutomatic.class);
    // Obtener la zona horaria definida en la propiedad "spring.jackson.time-zone"
    private final ZoneId zonaHoraria = ZoneId.of("America/La_Paz");
    private int idHorarioMateriaDocente;
    public SaveInPortImplAsistenciaAutomatic(
            IMqttPubTopicGateway iMqttPubTopicGateway,
            IViewOutPortDocente iViewOutPortDocente,
            IViewOutPortAula iViewOutPortAula,
            ISaveOrUpdateOutPortAsistencia iSaveOrUpdateOutPortAsistencia,
            IViewOutPortHorarioMateriaDocente iViewOutPortHorarioMateriaDocente,
            AsistenciaStatus asistenciaStatus) {

        this.iMqttPubTopicGateway = iMqttPubTopicGateway;
        this.iViewOutPortDocente = iViewOutPortDocente;
        this.iViewOutPortAula = iViewOutPortAula;
        this.iSaveOrUpdateOutPortAsistencia = iSaveOrUpdateOutPortAsistencia;
        this.iViewOutPortHorarioMateriaDocente = iViewOutPortHorarioMateriaDocente;
        this.asistenciaStatus = asistenciaStatus;
    }

    @Transactional
    @ServiceActivator(inputChannel = "mqttInputChannelAsistencia")
    public void saveAsistencia(Message<?> message) {
        MqttMessageAsistencia mqttMessage;
        // Crear objetos java.sql.Date y java.sql.Time a partir de la fecha y hora actuales
        Date date = Date.valueOf(LocalDate.now(this.zonaHoraria));
        Time time = Time.valueOf(LocalTime.now(this.zonaHoraria));

        try {
            // Convierte el mensaje recibido a un objeto MqttMessage
            mqttMessage = new ObjectMapper().readValue(
                    message.getPayload().toString(),
                    MqttMessageAsistencia.class);

            logger.debug("MqttMessage Object: " + mqttMessage.toString());

            Optional<DocenteViewDTO> docenteViewDTO = this.iViewOutPortDocente.viewByCodigoRfidDocenteDTO(
                    mqttMessage.getCodigoRfid());

            Optional<CommandAula> commandAula = this.iViewOutPortAula.viewByIdAulaDTO(mqttMessage.getIdAula());


            if(docenteViewDTO.isPresent() && commandAula.isPresent()) {

                Optional<CommandAsistencia> asistencia = this.iSaveOrUpdateOutPortAsistencia.saveOrUpdateAsistencia(
                        CommandAsistencia.builder()
                                .horaEntrada(time)
                                .cantidadEstudiantes(0)
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

                asistencia.ifPresent(

                        commandAsistencia -> this.iMqttPubTopicGateway.sendMessageMqtt(
                                this.asistenciaResponse,
                                MqttMessageResponseAsistencia.builder()
                                    .idAsistencia(commandAsistencia.getIdAsistencia())
                                    .estado("OK")
                                    .build().toString()
                        )
                );
            }else{
                this.iMqttPubTopicGateway.sendMessageMqtt(
                        this.asistenciaResponse,
                        MqttMessageResponseAsistencia.builder()
                                .idAsistencia(0)
                                .estado("ERROR")
                                .build().toString()
                );
            }
        } catch (Exception ex){
            this.iMqttPubTopicGateway.sendMessageMqtt(
                    this.asistenciaResponse,
                    MqttMessageResponseAsistencia.builder()
                            .idAsistencia(0)
                            .estado("ERROR")
                            .build().toString()
            );
            // Maneja la excepción de acuerdo a tus necesidades
            logger.error("Se produjo un error : " + ex.getMessage());
        }

    }

    private String getStatusAssistant(Long ci, String dia, Time time){
        Set<HorarioMateriaDocenteDTO> horarios =
                this.iViewOutPortHorarioMateriaDocente.viewByDocenteAndDiaDTO(ci, dia);

        return  this.asistenciaStatus.getDocenteLate(horarios, time).map(horario -> {
            logger.info("HorarioMateriaDocentesAtrasado =>" + horario);
            this.iMqttPubTopicGateway.sendMessageMqtt(materiaSendLcdTopic, horario.getMateria());
            this.idHorarioMateriaDocente = horario.getIdHorarioMateriaDocente();
            return "Impuntual";
        }).orElseGet(() ->  this.asistenciaStatus.getDocentePunctual(horarios, time).map(horario -> {
            logger.info("HorarioMateriaDocentesPuntuales =>" + horario);
            this.iMqttPubTopicGateway.sendMessageMqtt(materiaSendLcdTopic, horario.getMateria());
            this.idHorarioMateriaDocente = horario.getIdHorarioMateriaDocente();
            return "Puntual";
        }).orElse("Fuera de horario"));
    }
}
