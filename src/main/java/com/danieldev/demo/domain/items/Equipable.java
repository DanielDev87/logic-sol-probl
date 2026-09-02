package com.danieldev.demo.domain.items;

import com.danieldev.demo.domain.models.Personaje;

public sealed interface Equipable permits Arma, Pocion {
    String usar(Personaje objetivo);
    String getNombre();
}
