package com.control.asistencia.domain.mqttAsistencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MqttMessageAsistencia {
    private int idAula;
    private String codigoRfid;
}
