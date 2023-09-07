package com.control.asistencia.adapter.out.mqtt;

import com.control.asistencia.common.MqttAdapter;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MqttAdapter
@MessagingGateway(defaultRequestChannel = "mqttOutputChannel")
public interface IMqttPubTopicGateway {
    // Método para enviar un mensaje a un tema específico usando el encabezado mqtt_topic
    void sendMessageMqtt(@Header(MqttHeaders.TOPIC) String topic, String payload);
}
