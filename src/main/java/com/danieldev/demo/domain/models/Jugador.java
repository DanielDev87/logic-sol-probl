package com.danieldev.demo.domain.models;

import com.danieldev.demo.domain.enums.EstadoJugador;

public class Jugador extends Personaje {
     private EstadoJugador estado;

     public Jugador(String nombre, int puntosVida, int puntosAtaque) {
        super(nombre, puntosVida, puntosAtaque);
        this.estado = EstadoJugador.SALUDABLE;
    }

     @Override
     public int calcaularDanio(){
        return this.puntosAtaque + (nivel * 2);
    }

     public EstadoJugador getEstado() {
        if (!estaVivo()) return EstadoJugador.DERROTADO;
        if (puntosVida < 30) return EstadoJugador.HERIDO;
        return estado;        
     }

     public void setEstado(EstadoJugador estado) {
         this.estado = estado;
     }

    

     
     
}
