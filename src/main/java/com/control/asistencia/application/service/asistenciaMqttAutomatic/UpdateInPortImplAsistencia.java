package com.control.asistencia.application.service.asistenciaMqttAutomatic;

import com.control.asistencia.adapter.out.mqtt.IMqttPubTopicGateway;
import com.control.asistencia.application.port.out.asistencia.ISaveOrUpdateOutPortAsistencia;
import com.control.asistencia.common.UseCase;
import com.control.asistencia.domain.mqttAsistencia.MqttMessageResponseNumberEstudiante;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.transaction.annotation.Transactional;

@UseCase
public class UpdateInPortImplAsistencia {

    @Value("${mqtt.cantidad-estudiante-respuesta-pub}")
    private String numberStudentsUpdateTopic;
    private final IMqttPubTopicGateway iMqttPubTopicGateway;
    private final ISaveOrUpdateOutPortAsistencia iSaveOrUpdateOutPortAsistencia;
    public UpdateInPortImplAsistencia(
            IMqttPubTopicGateway iMqttPubTopicGateway,
            ISaveOrUpdateOutPortAsistencia iSaveOrUpdateOutPortAsistencia) {

        this.iMqttPubTopicGateway = iMqttPubTopicGateway;
        this.iSaveOrUpdateOutPortAsistencia = iSaveOrUpdateOutPortAsistencia;
    }

    @Transactional
    @ServiceActivator(inputChannel = "mqttInputChannelCantidad")
    public void updateAsistenciaAddCantStudent(Message<?> message) {
        MqttMessageResponseNumberEstudiante mqttMessage;
        try{
            // Convierte el mensaje recibido a un objeto MqttMessage
            mqttMessage = new ObjectMapper().readValue(
                    message.getPayload().toString(),
                    MqttMessageResponseNumberEstudiante.class);

            // Actualizar la cantidad de estudiantes en la asistencia
            if(this.iSaveOrUpdateOutPortAsistencia.updateMqttNumberStudentAsistencia(mqttMessage)){
                // Enviar mensaje de respuesta al LCD
                this.iMqttPubTopicGateway.sendMessageMqtt(numberStudentsUpdateTopic, "OK");
            }
        }catch (Exception e) {
            this.iMqttPubTopicGateway.sendMessageMqtt(numberStudentsUpdateTopic, "ERROR");
            throw new RuntimeException("Se produjo un error : " + e.getMessage(), e);
        }

    }
}
