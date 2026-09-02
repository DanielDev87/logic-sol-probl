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
        objetivo.curar(curacion);
        return "Mensaje que quiero retornar";
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    public int getCuracion() {
        return curacion;
    }

    

    

}
