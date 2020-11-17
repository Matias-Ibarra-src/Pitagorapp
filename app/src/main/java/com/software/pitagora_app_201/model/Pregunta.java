package com.software.pitagora_app_201.model;

public class Pregunta {

    String LocalId;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    String pregunta;

    public String getLocalId() {
        return LocalId;
    }

    public void setLocalId(String localId) {
        LocalId = localId;
    }



    public int getRespuestaCorrecta() {
        return RespuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        RespuestaCorrecta = respuestaCorrecta;
    }

    public int getRespuesta1() {
        return Respuesta1;
    }

    public void setRespuesta1(int respuesta1) {
        Respuesta1 = respuesta1;
    }

    public int getRespuesta2() {
        return Respuesta2;
    }

    public void setRespuesta2(int respuesta2) {
        Respuesta2 = respuesta2;
    }

    public int getRespuesta3() {
        return Respuesta3;
    }

    public void setRespuesta3(int respuesta3) {
        Respuesta3 = respuesta3;
    }

    public int getRespuesta4() {
        return Respuesta4;
    }

    public void setRespuesta4(int respuesta4) {
        Respuesta4 = respuesta4;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int puntaje) {
        Puntaje = puntaje;
    }

    int RespuestaCorrecta;
    int Respuesta1;
    int Respuesta2;
    int Respuesta3;
    int Respuesta4;
    int Puntaje;



    @Override
    public String toString() {
        return LocalId;
    }

}
