package com.danieldev.demo.logic;

import java.util.ArrayList;
import java.util.SequencedCollection;

import com.danieldev.demo.domain.items.Equipable;

public class ManejadorEventos {

    private final SequencedCollection<Equipable> inventario = new ArrayList<>();

    public void agregarItem(Equipable item){
        inventario.addLast(item);
        System.out.println("El item agregado es: " + item.getNombre());
    }

    public Equipable obtenerUltimo(){
        return inventario.isEmpty() ? null : inventario.getLast();
    }

}
