package com.danieldev.demo.domain.models;

import com.danieldev.demo.domain.enums.TipoElemento;

public class Enemigo extends Personaje {
    private final TipoElemento tipoElemento;

    public Enemigo(String nombre, int puntosVida, int puntosAtaque, TipoElemento tipoElemento) {
        super(nombre, puntosVida, puntosAtaque);
        this.tipoElemento = tipoElemento;
    }
    @Override
    public int calcaularDanio(){
    return  (int) (this.puntosAtaque * tipoElemento.getMultiplicador());
    }
    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

}
