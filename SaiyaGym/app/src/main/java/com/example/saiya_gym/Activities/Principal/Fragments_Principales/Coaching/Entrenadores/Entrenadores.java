package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores;

import java.io.Serializable;

public class Entrenadores implements Serializable {
    private String nombre;
    private String informacion;
    private int imagen;
    private String lunesE,martesE,miercolesE,juevesE,viernesE;
    private String lunesDi,martesDi,miercolesDi,JuevesDi,viernesDi;

    public Entrenadores(String nombre, String informacion, int imagen, String lunesE, String martesE, String miercolesE, String juevesE, String viernesE, String lunesDi, String martesDi, String miercolesDi, String juevesDi, String viernesDi) {
        this.nombre = nombre;
        this.informacion = informacion;
        this.imagen = imagen;
        this.lunesE = lunesE;
        this.martesE = martesE;
        this.miercolesE = miercolesE;
        this.juevesE = juevesE;
        this.viernesE = viernesE;
        this.lunesDi = lunesDi;
        this.martesDi = martesDi;
        this.miercolesDi = miercolesDi;
        JuevesDi = juevesDi;
        this.viernesDi = viernesDi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getLunesE() {
        return lunesE;
    }

    public void setLunesE(String lunesE) {
        this.lunesE = lunesE;
    }

    public String getMartesE() {
        return martesE;
    }

    public void setMartesE(String martesE) {
        this.martesE = martesE;
    }

    public String getMiercolesE() {
        return miercolesE;
    }

    public void setMiercolesE(String miercolesE) {
        this.miercolesE = miercolesE;
    }

    public String getJuevesE() {
        return juevesE;
    }

    public void setJuevesE(String juevesE) {
        this.juevesE = juevesE;
    }

    public String getViernesE() {
        return viernesE;
    }

    public void setViernesE(String viernesE) {
        this.viernesE = viernesE;
    }

    public String getLunesDi() {
        return lunesDi;
    }

    public void setLunesDi(String lunesDi) {
        this.lunesDi = lunesDi;
    }

    public String getMartesDi() {
        return martesDi;
    }

    public void setMartesDi(String martesDi) {
        this.martesDi = martesDi;
    }

    public String getMiercolesDi() {
        return miercolesDi;
    }

    public void setMiercolesDi(String miercolesDi) {
        this.miercolesDi = miercolesDi;
    }

    public String getJuevesDi() {
        return JuevesDi;
    }

    public void setJuevesDi(String juevesDi) {
        JuevesDi = juevesDi;
    }

    public String getViernesDi() {
        return viernesDi;
    }

    public void setViernesDi(String viernesDi) {
        this.viernesDi = viernesDi;
    }
}
