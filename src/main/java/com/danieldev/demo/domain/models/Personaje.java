package com.danieldev.demo.domain.models;

import java.util.UUID;

public abstract class Personaje {
     //Atributos
    protected final String id;
    protected   String nombre;
    protected  int nivel;
    protected  int puntosVida;
    protected int puntosAtaque;

    public Personaje( String nombre, int puntosVida, int puntosAtaque) {
        this.id =UUID.randomUUID().toString();
        this.nombre = nombre;
        this.nivel = 1;
        this.puntosVida = validarVidaInicial(puntosVida);
        this.puntosAtaque = puntosAtaque;
    }

    private int validarVidaInicial(int vida){
        return (vida <= 0)? 100: vida;
    }

    public abstract int calcaularDanio();

    public void recibirDanio(int danio){
        if (danio > 0) {
            this.puntosVida = Math.max(0, this.puntosVida - danio);
            System.out.println(
                this.nombre + " has recibido "
                + danio + "de daño. tu vida actual es: "
                +  this.puntosVida);
        }
    }

    public void curar(int cantidad){
        if (cantidad > 0 && estaVivo()) {
           this.puntosVida += cantidad;
           System.out.println("Mensaje que se curó, cambiarlo"); 
        }
    }

    public boolean estaVivo(){
        return this.puntosVida > 0;
    }

     //getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

}
