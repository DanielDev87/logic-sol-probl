package com.danieldev.demo.logic;

public class ExcepcionesJuego {
    public static class InventarioLlenoException extends RuntimeException{

        public InventarioLlenoException(String mensaje) {
            super(mensaje);
        }               
    }

    public static class ItemNoEncontradoException extends RuntimeException{

        public ItemNoEncontradoException(String mensaje) {
            super(mensaje);
        }               
    }

}
