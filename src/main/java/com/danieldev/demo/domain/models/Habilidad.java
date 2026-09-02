package com.danieldev.demo.domain.models;

import com.danieldev.demo.domain.enums.TipoElemento;

public record Habilidad(String nombre, int danioExtra,TipoElemento elemento, int costoMana) {
    public Habilidad {
         if (costoMana< 0){
            throw new IllegalArgumentException("El costo del maá no puede ser negativo");
        }
    }               
}

