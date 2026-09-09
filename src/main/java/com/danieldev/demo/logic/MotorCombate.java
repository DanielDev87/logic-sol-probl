package com.danieldev.demo.logic;

import com.danieldev.demo.domain.items.Arma;
import com.danieldev.demo.domain.items.Equipable;
import com.danieldev.demo.domain.items.Pocion;
import com.danieldev.demo.domain.models.Personaje;

public class MotorCombate {

    public void ejecutarTurno(Personaje atacante, Personaje defensor){
        int danio = atacante.calcaularDanio();
        System.out.println("Mensaje personalizado del atacante" +  danio);
    }

    public void procesarObjeto(Equipable item, Personaje objetivo){
        String resultado = switch (item){
            case Pocion p -> p.usar(objetivo);
            case Arma a -> a.usar(objetivo);
        };
        System.out.println(resultado);
    }

}
