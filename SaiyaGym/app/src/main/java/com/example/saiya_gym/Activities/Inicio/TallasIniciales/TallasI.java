package com.example.saiya_gym.Activities.Inicio.TallasIniciales;

public class TallasI {
    private String usuario,hombros,pecho,espalda,brazos,abdomen,pierna;

    public TallasI(String usuario, String hombros, String pecho, String espalda, String brazos, String abdomen, String pierna) {
        this.usuario = usuario;
        this.hombros = hombros;
        this.pecho = pecho;
        this.espalda = espalda;
        this.brazos = brazos;
        this.abdomen = abdomen;
        this.pierna = pierna;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getHombros() {
        return hombros;
    }

    public void setHombros(String hombros) {
        this.hombros = hombros;
    }

    public String getPecho() {
        return pecho;
    }

    public void setPecho(String pecho) {
        this.pecho = pecho;
    }

    public String getEspalda() {
        return espalda;
    }

    public void setEspalda(String espalda) {
        this.espalda = espalda;
    }

    public String getBrazos() {
        return brazos;
    }

    public void setBrazos(String brazos) {
        this.brazos = brazos;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getPierna() {
        return pierna;
    }

    public void setPierna(String pierna) {
        this.pierna = pierna;
    }
}
