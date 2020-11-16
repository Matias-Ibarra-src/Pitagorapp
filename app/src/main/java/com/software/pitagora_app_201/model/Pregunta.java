package com.software.pitagora_app_201.model;

public class Pregunta {

    String LocalId;
    String pregunta;
    String RespuestaCorrecta;
    String Respuesta1;
    String Respuesta2;
    String Respuesta3;
    String Respuesta4;
    Integer Puntaje;

    public String getLocalId() {
        return LocalId;
    }

    public String getPregunta() {
        return pregunta;
    }

    public Integer getPuntaje() {
        return Puntaje;
    }

    public String getRespuesta1() {
        return Respuesta1;
    }

    public String getRespuesta2() {
        return Respuesta2;
    }

    public String getRespuesta3() {
        return Respuesta3;
    }

    public String getRespuesta4() {
        return Respuesta4;
    }

    public String getRespuestaCorrecta() {
        return RespuestaCorrecta;
    }

    @Override
    public String toString() {
        return LocalId;
    }

}
