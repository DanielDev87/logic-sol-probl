package com.danieldev.demo.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.danieldev.demo.domain.enums.TipoElemento;
import com.danieldev.demo.domain.items.Arma;
import com.danieldev.demo.domain.items.Pocion;
import com.danieldev.demo.domain.models.Enemigo;
import com.danieldev.demo.domain.models.Jugador;

class MotorCombateTests {

    private final MotorCombate motorCombate = new MotorCombate();

    @Test
    void turnoAplicaDanioYDerrotaAlEnemigo() {
        Jugador jugador = new Jugador("Luna", 100, 18);
        Enemigo enemigo = new Enemigo("Slime", 18, 4, TipoElemento.AGUA);

        String resultado = motorCombate.ejecutarTurno(jugador, enemigo);

        assertEquals(0, enemigo.getPuntosVida());
        assertFalse(enemigo.estaVivo());
        assertTrue(resultado.contains("derrotado"));
    }

    @Test
    void pocionCuraSinSuperarLaVidaMaxima() {
        Jugador jugador = new Jugador("Luna", 100, 18);
        jugador.recibirDanio(10);

        String resultado = motorCombate.procesarObjeto(
                new Pocion("Poción", 25), jugador);

        assertEquals(100, jugador.getPuntosVida());
        assertTrue(resultado.contains("recupera 10"));
    }

    @Test
    void armaAplicaDanioConMultiplicadorElemental() {
        Enemigo enemigo = new Enemigo("Slime", 50, 4, TipoElemento.AGUA);
        Arma arma = new Arma("Espada ígnea", 10, TipoElemento.FUEGO);

        motorCombate.procesarObjeto(arma, enemigo);

        assertEquals(35, enemigo.getPuntosVida());
    }

    @Test
    void personajeDerrotadoNoPuedeCombatir() {
        Jugador jugador = new Jugador("Luna", 100, 18);
        Enemigo enemigo = new Enemigo("Slime", 10, 4, TipoElemento.AGUA);
        enemigo.recibirDanio(10);

        assertThrows(IllegalStateException.class,
                () -> motorCombate.ejecutarTurno(jugador, enemigo));
    }
}
