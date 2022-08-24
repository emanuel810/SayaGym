package com.example.saiya_gym.Activities.Principal.Fragments_Principales;


import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Entrenadores.Entrenadores;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Coaching.Rutinas.Musculos.Musculos;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Inicio.Noticias.Noticias;
import com.example.saiya_gym.Activities.Principal.Fragments_Principales.Ventas.Ventas;

public interface iComunicaFragments {
    public void enviarComida(Ventas ventas);
    public void enviarNoticia(Noticias noticias);
    public void enviarPrenda(Ventas ventas);
    public void enviarBebida(Ventas ventas);
    public void enviarSuplemento(Ventas ventas);
    public void enviarPecho(Musculos musculos);
    public void enviarHombros(Musculos musculos);
    public void enviarEspalda(Musculos musculos);
    public void enviarBiceps(Musculos musculos);
    public void enviarTriceps(Musculos musculos);
    public void enviarAbdomen(Musculos musculos);
    public void enviarPiernas(Musculos musculos);
    public void enviarEntrenadores(Entrenadores entrenadores);


}
