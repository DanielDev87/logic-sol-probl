package com.danieldev.demo.domain.items;

import com.danieldev.demo.domain.enums.TipoElemento;
import com.danieldev.demo.domain.models.Personaje;

public record Arma(String nombre, int danio, TipoElemento elemento) implements  Equipable {
   @Override
    public String usar(Personaje objetivo){
        return "Acá va un mensaje en relación al arma y el personaje";
    }

    @Override
    public String getNombre(){ return nombre;}
}
