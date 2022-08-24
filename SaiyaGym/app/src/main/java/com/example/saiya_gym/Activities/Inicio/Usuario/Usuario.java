package com.example.saiya_gym.Activities.Inicio.Usuario;

public class Usuario {

    private String nombre,usuario,contraseña,edad,pesoInicial,pesoFinal;



    public  Usuario(){}

    public Usuario(String nombre, String usuario, String contraseña, String edad, String pesoInicial, String pesoFinal) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.edad = edad;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(String pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public String getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(String pesoFinal) {
        this.pesoFinal = pesoFinal;
    }
}
