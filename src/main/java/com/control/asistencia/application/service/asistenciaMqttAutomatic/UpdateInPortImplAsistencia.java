package com.control.asistencia.application.service.asistenciaMqttAutomatic;

import com.control.asistencia.adapter.out.mqtt.IMqttPubTopicGateway;
import com.control.asistencia.common.UseCase;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@UseCase
public class UpdateInPortImplAsistencia {
    private final IMqttPubTopicGateway iMqttPubTopicGateway;
    public UpdateInPortImplAsistencia(
            IMqttPubTopicGateway iMqttPubTopicGateway) {

        this.iMqttPubTopicGateway = iMqttPubTopicGateway;
    }

    @ServiceActivator(inputChannel = "mqttInputChannelCantidad")
    public void updateAsistenciaAddCantStudent(Message<?> message) {

    }
}
