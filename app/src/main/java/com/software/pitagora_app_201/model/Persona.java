package com.software.pitagora_app_201.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Serializable {
    private String Localid;
    private String Nombre;
    private String Apellido;
    private String Numero;
    private String Correo;
    private String Password;

    //preguntas correctas por nivel
    private String correctas_en_geo;
    private String correctas_en_alg;

    public String getCorrectas_en_geo() {
        return correctas_en_geo;
    }

    public void setCorrectas_en_geo(String correctas_en_geo) {
        this.correctas_en_geo = correctas_en_geo;
    }

    public String getCorrectas_en_alg() {
        return correctas_en_alg;
    }

    public void setCorrectas_en_alg(String correctas_en_alg) {
        this.correctas_en_alg = correctas_en_alg;
    }

    public String getCorrectas_en_pro() {
        return correctas_en_pro;
    }

    public void setCorrectas_en_pro(String correctas_en_pro) {
        this.correctas_en_pro = correctas_en_pro;
    }

    public String getCorrectas_en_num() {
        return correctas_en_num;
    }

    public void setCorrectas_en_num(String correctas_en_num) {
        this.correctas_en_num = correctas_en_num;
    }

    public String getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(String puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    private String correctas_en_pro;
    private String correctas_en_num;

    private String puntajeTotal;
    //private List<String> listpreguntasContestadas = new ArrayList<String>();


    public Persona() {
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getLocalid() {
        return Localid;
    }

    public void setLocalid(String Localid) {
        this.Localid = Localid;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return Nombre;
    }

    /*public List<String> getListpreguntasContestadas() {
        return listpreguntasContestadas;
    }

    public void setListpreguntasContestadas(List<String> listpreguntasContestadas) {
        this.listpreguntasContestadas = listpreguntasContestadas;
    }*/


}
