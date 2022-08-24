package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas;

import java.io.Serializable;

public class Ventas implements Serializable {

    private String titulo;
    private String contenido;
    private String precio;
    private int imagen;


    public Ventas(String titulo, String contenido, String precio, int imagen) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.precio = precio;
        this.imagen = imagen;
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

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
