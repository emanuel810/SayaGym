package com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Musculos;

import java.io.Serializable;

public class Musculos implements Serializable {

    private String titulo;
    private int imagen;

    public Musculos(String titulo, int imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
