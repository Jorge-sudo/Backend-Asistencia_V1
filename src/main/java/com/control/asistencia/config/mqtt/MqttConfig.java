package com.control.asistencia.config.mqtt;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
@EnableIntegration
public class MqttConfig {

    // Inyección de dependencia de las propiedades definidas en application.properties
    // Estas propiedades incluyen la dirección del servidor MQTT, opciones de conexión y credenciales de autenticación
    @Value("${mqtt.hostname}")
    private String mqttHostname;

    @Value("${mqtt.options.automatic-reconnect}")
    private boolean mqttAutomaticReconnect;

    @Value("${mqtt.options.clean-session}")
    private boolean mqttCleanSession;

    @Value("${mqtt.options.connection-timeout}")
    private int mqttConnectionTimeout;

    @Value("${mqtt.options.user-name}")
    private String mqttUserName;

    @Value("${mqtt.options.password}")
    private String mqttPassword;

    @Value("${mqtt.asistencia-channel}")
    private String mqttAsistenciaTopic;

    @Value("${mqtt.cantidad-estudiante-channel}")
    private String mqttCantidadEstudianteTopic;

    // Configuración del cliente MQTT
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        // Creación de un objeto DefaultMqttPahoClientFactory para configurar la conexión
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        // Creación de un objeto MqttConnectOptions para configurar los detalles de la conexión
        MqttConnectOptions options = new MqttConnectOptions();
        // Establecimiento de la dirección del servidor MQTT al que se conectará el cliente
        options.setServerURIs(new String[] { mqttHostname });
        // Configuración de la opción de reconexión automática del cliente
        options.setAutomaticReconnect(mqttAutomaticReconnect);
        // Configuración de la opción de sesión limpia del cliente
        options.setCleanSession(mqttCleanSession);
        // Configuración del tiempo de espera de la conexión
        options.setConnectionTimeout(mqttConnectionTimeout);
        // Configuración del nombre de usuario y contraseña para la autenticación
        options.setUserName(mqttUserName);
        options.setPassword(mqttPassword.toCharArray());
        // Establecimiento de las opciones de conexión en el objeto DefaultMqttPahoClientFactory
        factory.setConnectionOptions(options);
        return factory;
    }

    // Canal de entrada para mensajes MQTT para Asistencia
    @Bean
    public MessageChannel mqttInputChannelTopicAsistencia() {
        return new DirectChannel();
    }

    // Nuevos canales de entrada para Materia
    @Bean
    public MessageChannel mqttInputChannelCantidadEstudiante() {
        return new DirectChannel();
    }

    // Canal de salida para mensajes MQTT
    @Bean
    public MessageChannel mqttOutputChannel() { // Agregado
        return new DirectChannel();
    }

    // Adaptador para recibir mensajes del servidor MQTT de asistencia
    @Bean
    public MessageProducer mqttInboundAdapterTopicAsistencia() {
        // Creación de un objeto MqttPahoMessageDrivenChannelAdapter para recibir mensajes del servidor MQTT
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(
                        "mqttInboundAdapter-" + mqttAsistenciaTopic, mqttClientFactory(), mqttAsistenciaTopic);
        // Establecimiento del tiempo de espera de la operación de recepción
        adapter.setCompletionTimeout(5000);
        // Configuración del convertidor de mensajes a utilizar
        adapter.setConverter(new DefaultPahoMessageConverter());
        // Establecimiento del nivel de calidad de servicio (QoS) para la recepción de mensajes
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannelTopicAsistencia()); // Conexión del canal de entrada MQTT al adaptador MQTT
        return adapter;
    }

    // Adaptador para recibir mensajes del servidor MQTT de materia
    @Bean
    public MessageProducer mqttInboundAdapterCantidadEstudiante() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(
                        "mqttInboundAdapter-" + mqttCantidadEstudianteTopic, mqttClientFactory(), mqttCantidadEstudianteTopic);
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannelCantidadEstudiante());
        return adapter;
    }

    // Canal de salida para enviar mensajes MQTT
    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    // Manejador para enviar mensajes al servidor MQTT
    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutboundHandler() {
        // Creación de un objeto MqttPahoMessageHandler para enviar mensajes al servidor MQTT
        MqttPahoMessageHandler messageHandler =
                new MqttPahoMessageHandler(
                        "mqttOutboundHandler", mqttClientFactory());
        // Configuración del envío asíncrono de mensajes
        messageHandler.setAsync(true);
        // Establecimiento del tema predeterminado para enviar mensajes
        messageHandler.setDefaultTopic(mqttAsistenciaTopic);
        // Establecimiento del nivel de calidad de servicio (QoS) predeterminado para enviar mensajes
        messageHandler.setDefaultQos(2);
        return messageHandler;
    }

}