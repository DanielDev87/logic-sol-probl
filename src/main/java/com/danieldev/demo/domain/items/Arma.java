package com.danieldev.demo.domain.items;

import com.danieldev.demo.domain.enums.TipoElemento;
import com.danieldev.demo.domain.models.Personaje;

public record Arma(String nombre, int danio, TipoElemento elemento) implements  Equipable {
    public Arma {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del arma es obligatorio.");
        }
        if (danio <= 0) {
            throw new IllegalArgumentException("El daño del arma debe ser mayor que cero.");
        }
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento del arma es obligatorio.");
        }
    }

   @Override
    public String usar(Personaje objetivo){
        if (objetivo == null) {
            throw new IllegalArgumentException("El objetivo del arma es obligatorio.");
        }
        if (!objetivo.estaVivo()) {
            return objetivo.getNombre() + " ya ha sido derrotado.";
        }
        int danioAplicado = (int) Math.round(danio * elemento.getMultiplicador());
        objetivo.recibirDanio(danioAplicado);
        return nombre + " de " + elemento.name().toLowerCase()
                + " causa " + danioAplicado + " de daño a " + objetivo.getNombre()
                + ". Vida restante: " + objetivo.getPuntosVida() + "/"
                + objetivo.getPuntosVidaMaximos() + ".";
    }

    @Override
    public String getNombre(){ return nombre;}
}
