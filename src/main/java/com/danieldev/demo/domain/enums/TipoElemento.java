package com.danieldev.demo.domain.enums;

public enum TipoElemento {
    FUEGO(1.5, "🔥"),
    AGUA(1.0, "🌊"),
    TIERRA(0.8, "⏳"),
    VIENTO(1.2, "🌪️");

    private final double multiplicador;
    private final String icono;

    private TipoElemento(double multiplicador, String icono) {
        this.multiplicador = multiplicador;
        this.icono = icono;
    }

    public double getMultiplicador() {
        return multiplicador;
    }

    public String getIcono() {
        return icono;
    }   
    
}
