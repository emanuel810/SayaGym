package com.example.saiya_gym.Activities.Inicio.Entrenadores;

public class Entrenadores {
    private String usuarioE,entrenadoresE,lunes,martes,miercoles,jueves,viernes;
    private String lunesD,martesD,miercolesD,JuevesD,viernesD;

    public Entrenadores(){}

    public Entrenadores(String usuarioE, String entrenadoresE, String lunes, String martes, String miercoles, String jueves, String viernes, String lunesD, String martesD, String miercolesD, String juevesD, String viernesD) {
        this.usuarioE = usuarioE;
        this.entrenadoresE = entrenadoresE;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.lunesD = lunesD;
        this.martesD = martesD;
        this.miercolesD = miercolesD;
        JuevesD = juevesD;
        this.viernesD = viernesD;
    }

    public String getUsuarioE() {
        return usuarioE;
    }

    public void setUsuarioE(String usuarioE) {
        this.usuarioE = usuarioE;
    }

    public String getEntrenadoresE() {
        return entrenadoresE;
    }

    public void setEntrenadoresE(String entrenadoresE) {
        this.entrenadoresE = entrenadoresE;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

    public String getLunesD() {
        return lunesD;
    }

    public void setLunesD(String lunesD) {
        this.lunesD = lunesD;
    }

    public String getMartesD() {
        return martesD;
    }

    public void setMartesD(String martesD) {
        this.martesD = martesD;
    }

    public String getMiercolesD() {
        return miercolesD;
    }

    public void setMiercolesD(String miercolesD) {
        this.miercolesD = miercolesD;
    }

    public String getJuevesD() {
        return JuevesD;
    }

    public void setJuevesD(String juevesD) {
        JuevesD = juevesD;
    }

    public String getViernesD() {
        return viernesD;
    }

    public void setViernesD(String viernesD) {
        this.viernesD = viernesD;
    }
}
