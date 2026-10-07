package com.danieldev.demo.logic;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.danieldev.demo.domain.enums.TipoElemento;
import com.danieldev.demo.domain.items.Pocion;
import com.danieldev.demo.domain.models.Enemigo;
import com.danieldev.demo.domain.models.Jugador;

@Component
@ConditionalOnProperty(name = "game.console", havingValue = "true", matchIfMissing = true)
public class JuegoConsola implements CommandLineRunner {

    private final MotorCombate motorCombate = new MotorCombate();

    @Override
    public void run(String... args) {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("=== BATALLA ELEMENTAL ===");
            System.out.print("Escribe el nombre de tu personaje: ");
            if (!entrada.hasNextLine()) {
                return;
            }

            String nombre = entrada.nextLine().trim();
            if (nombre.isEmpty()) {
                nombre = "Aventurero";
            }

            jugar(entrada, nombre);
        }
    }

    private void jugar(Scanner entrada, String nombre) {
        Jugador jugador = new Jugador(nombre, 100, 18);
        Enemigo enemigo = new Enemigo("Gólem de fuego", 65, 10, TipoElemento.FUEGO);
        Pocion pocion = new Pocion("Poción de vida", 25);
        boolean pocionDisponible = true;

        System.out.println("\nDerrota al " + enemigo.getNombre() + " para ganar.");
        while (jugador.estaVivo() && enemigo.estaVivo()) {
            System.out.println("\nTu vida: " + jugador.getPuntosVida()
                    + " | Vida del enemigo: " + enemigo.getPuntosVida());
            System.out.println("1. Atacar  2. Usar poción  0. Salir");
            System.out.print("> ");

            if (!entrada.hasNextLine()) {
                return;
            }

            String opcion = entrada.nextLine().trim();
            switch (opcion) {
                case "1" -> {
                    System.out.println(motorCombate.ejecutarTurno(jugador, enemigo));
                    if (enemigo.estaVivo()) {
                        turnoEnemigo(jugador, enemigo);
                    }
                }
                case "2" -> {
                    if (!pocionDisponible) {
                        System.out.println("Ya usaste tu única poción.");
                    } else if (jugador.getPuntosVida() == jugador.getPuntosVidaMaximos()) {
                        System.out.println("Ya tienes toda tu vida.");
                    } else {
                        System.out.println(motorCombate.procesarObjeto(pocion, jugador));
                        pocionDisponible = false;
                        turnoEnemigo(jugador, enemigo);
                    }
                }
                case "0" -> {
                    System.out.println("Has abandonado la partida.");
                    return;
                }
                default -> System.out.println("Opción no válida. Elige 1, 2 o 0.");
            }
        }

        if (jugador.estaVivo()) {
            System.out.println("\n¡Victoria! Has derrotado al " + enemigo.getNombre() + ".");
        } else {
            System.out.println("\nHas sido derrotado. Inténtalo de nuevo.");
        }
    }

    private void turnoEnemigo(Jugador jugador, Enemigo enemigo) {
        if (jugador.estaVivo()) {
            System.out.println(motorCombate.ejecutarTurno(enemigo, jugador));
        }
    }

}
