package com.control.asistencia.application.port.in.imagePersona;

import java.io.IOException;
import java.net.MalformedURLException;

public interface IViewInPortImagePersona {
    boolean thisImagePersonaExists(String nameImg) throws IOException;
}
