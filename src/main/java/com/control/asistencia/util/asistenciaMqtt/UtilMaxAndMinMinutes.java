package com.control.asistencia.util.asistenciaMqtt;

import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class UtilMaxAndMinMinutes {
    public static Time increaseMinutes(Time time){
        //minutos de tolerancia ejemplo la entrada es 10:00 y la tolerancia
        // es 5 minutos, entonces el docente puede entrar hasta las 10:05
        final int minutesTolerance = 5;
        return new Time(time.getTime() + minutesTolerance * 60 * 1000);// sumamos 5 minutos en milisegundos
    }

    public static Time delayMinutes(Time time){
        //minutos antes de la entrada para que se pueda registrar la asistencia,
        // ejemplo la entrada es 10:00 y el docente puede registrar su asistencia desde las 9:50
        final int minutesBeforeEntry = 15;
        return new Time(time.getTime() - minutesBeforeEntry * 60 * 1000);// restamos 15 minutos en milisegundos
    }
}
