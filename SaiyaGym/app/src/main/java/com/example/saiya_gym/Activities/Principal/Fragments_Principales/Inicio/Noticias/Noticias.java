package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Noticias;

import java.io.Serializable;

public class Noticias implements Serializable {
    private String titulo;
    private String contenido;
    private int imagenId;


    public Noticias(){}
    public Noticias(String titulo, String contenido, int imagenId) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagenId = imagenId;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getImagenId() { return imagenId; }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
