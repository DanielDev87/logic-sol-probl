package com.danieldev.demo.domain.items;

import com.danieldev.demo.domain.models.Personaje;

public final class Pocion implements Equipable {
    private final String nombre;
    private final int curacion;

    public Pocion(String nombre, int curacion) {
        this.nombre = nombre;
        this.curacion = curacion;
    }
    @Override
    public String usar(Personaje objetivo){
        if (objetivo == null) {
            throw new IllegalArgumentException("El objetivo de la poción es obligatorio.");
        }
        int vidaAntes = objetivo.getPuntosVida();
        objetivo.curar(curacion);
        int vidaRecuperada = objetivo.getPuntosVida() - vidaAntes;
        if (vidaRecuperada == 0) {
            return objetivo.estaVivo()
                    ? objetivo.getNombre() + " ya tiene toda su vida."
                    : objetivo.getNombre() + " no puede recibir curación porque ha sido derrotado.";
        }
        return objetivo.getNombre() + " recupera " + vidaRecuperada + " puntos de vida.";
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    public int getCuracion() {
        return curacion;
    }   

}
