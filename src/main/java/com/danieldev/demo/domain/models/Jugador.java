package com.danieldev.demo.domain.models;

import java.util.UUID;

public class Jugador {
    //Atributos
    private final String id;
    private final String nombre;
    private int nivel;
    private int puntosVida;
    private int puntosAtaque;
    
    //Constructor
    public Jugador(String id, String nombre, int nivel, int puntosVida, int puntosAtaque) {
        this.id =UUID.randomUUID().toString();
        this.nombre = nombre;
        this.nivel = 1;
        this.puntosVida = validarVidaInicial(puntosVida);
        this.puntosAtaque = puntosAtaque;
    }
    //Método para proyeger el estdo 
    private int validarVidaInicial(int vida){
        return (vida <= 0)? 100: vida;
    }
    //Métodos con lógica de negocio(comportamiento)
    public void recibirDanio(int danio){
        if (danio > 0) {
            this.puntosVida = Math.max(0, this.puntosVida - danio);
            System.out.println(
                this.nombre + " has recibido "
                + danio + "de daño. tu vida actual es: "
                +  this.puntosVida);
        }
    }
    
    
}
