package com.danieldev.demo.logic;

import com.danieldev.demo.domain.items.Equipable;
import com.danieldev.demo.domain.models.Personaje;

public class MotorCombate {

    public String ejecutarTurno(Personaje atacante, Personaje defensor){
        if (atacante == null || defensor == null) {
            throw new IllegalArgumentException("El atacante y el defensor son obligatorios.");
        }
        if (!atacante.estaVivo() || !defensor.estaVivo()) {
            throw new IllegalStateException("Solo pueden combatir personajes vivos.");
        }

        int danio = atacante.calcaularDanio();
        defensor.recibirDanio(danio);

        String resultado = atacante.getNombre() + " causa " + danio
                + " de daño a " + defensor.getNombre() + ". Vida restante: "
                + defensor.getPuntosVida() + "/" + defensor.getPuntosVidaMaximos() + ".";
        if (!defensor.estaVivo()) {
            resultado += " " + defensor.getNombre() + " ha sido derrotado.";
        }
        return resultado;
    }

    public String procesarObjeto(Equipable item, Personaje objetivo){
        if (item == null || objetivo == null) {
            throw new IllegalArgumentException("El objeto y el objetivo son obligatorios.");
        }
        return item.usar(objetivo);
    }

}
