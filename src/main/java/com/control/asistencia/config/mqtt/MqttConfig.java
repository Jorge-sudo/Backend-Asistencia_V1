package com.control.asistencia.config.mqtt;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
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

    @Value("${mqtt.asistencia-topic-sub}")
    private String mqttAsistenciaTopic;

    @Value("${mqtt.cantidad-estudiante-topic-sub}")
    private String mqttCantidadEstudianteTopic;

    // Configuración del cliente MQTT agregamos los atributos como usuario y etc.
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        // Creación de un objeto DefaultMqttPahoClientFactory para configurar la conexión
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        // Creación de un objeto MqttConnectOptions para configurar los detalles de la conexión
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[] { mqttHostname });
        options.setAutomaticReconnect(mqttAutomaticReconnect);
        options.setCleanSession(mqttCleanSession);
        options.setConnectionTimeout(mqttConnectionTimeout);
        options.setUserName(mqttUserName);
        options.setPassword(mqttPassword.toCharArray());
        factory.setConnectionOptions(options);
        return factory;
    }


    // Adaptador para recibir mensajes del servidor MQTT de cantidad de estudiantes
    @Bean
    public MessageProducer mqttInboundAdapterTopicCantidad() {
        // Creación de un objeto MqttPahoMessageDrivenChannelAdapter para recibir mensajes del servidor MQTT
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(
                        MqttAsyncClient.generateClientId(), // Identificador del cliente MQTT
                        mqttClientFactory(),
                        mqttCantidadEstudianteTopic);

        // Establecimiento del tiempo de espera de la operación de recepción
        adapter.setCompletionTimeout(5000);
        // Configuración del convertidor de mensajes a utilizar
        adapter.setConverter(new DefaultPahoMessageConverter());
        // Establecimiento del nivel de calidad de servicio (QoS) para la recepción de mensajes
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannelCantidad()); // Conexión del canal de entrada MQTT al adaptador MQTT
        return adapter;
    }

    // Adaptador para recibir mensajes del servidor MQTT de asistencia
    @Bean
    public MessageProducer mqttInboundAdapterTopicAsistencia() {
        // Creación de un objeto MqttPahoMessageDrivenChannelAdapter para recibir mensajes del servidor MQTT
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(
                        MqttAsyncClient.generateClientId(), // Identificador del cliente MQTT
                        mqttClientFactory(),
                        mqttAsistenciaTopic);

        // Establecimiento del tiempo de espera de la operación de recepción
        adapter.setCompletionTimeout(5000);
        // Configuración del convertidor de mensajes a utilizar
        adapter.setConverter(new DefaultPahoMessageConverter());
        // Establecimiento del nivel de calidad de servicio (QoS) para la recepción de mensajes
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannelAsistencia()); // Conexión del canal de entrada MQTT al adaptador MQTT
        return adapter;
    }


    // Manejador para enviar mensajes al servidor MQTT
    @Bean
    @ServiceActivator(inputChannel = "mqttOutputChannel")
    public MessageHandler mqttOutboundHandler() {
        // Creación de un objeto MqttPahoMessageHandler para enviar mensajes al servidor MQTT
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(
                        //  necesario
                        MqttAsyncClient.generateClientId(), // Identificador del cliente MQTT
                        mqttClientFactory());

        // Configuración del envío asíncrono de mensajes
        messageHandler.setAsync(true);
        // Establecimiento del tema predeterminado para enviar mensajes
        messageHandler.setDefaultTopic(mqttAsistenciaTopic);
        // Establecimiento del nivel de calidad de servicio (QoS) predeterminado para enviar mensajes
        messageHandler.setDefaultQos(2);
        return messageHandler;
    }


    // Configuración del canal de entrada al que se enviarán los mensajes recibidos por el adaptador MQTT
    @Bean
    public MessageChannel mqttInputChannelAsistencia() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel mqttInputChannelCantidad() {
        return new DirectChannel();
    }

    // Configuración del canal de salida desde el que se enviarán los mensajes al manejador MQTT
    @Bean
    public MessageChannel mqttOutputChannel() {
        return new DirectChannel();
    }


}