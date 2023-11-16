package edu.fiuba.algo3.modelo;

import javafx.geometry.Pos;

import java.util.ArrayList;

public class Gladiador {

    private String nombre;
    private Energia energia;
    private Posicion posicion;
    private ArrayList<Equipamiento> equipamientos;

    public Gladiador(String nombre, Energia energia, Posicion posicion){
        this.nombre = nombre;
        this.energia = energia;
        this.equipamientos = new ArrayList<Equipamiento>();
        this.posicion = posicion;
    }

    public ArrayList<Equipamiento> obtenerEquipamiento(){
        return equipamientos;
    }

    public void mover(Posicion nuevaPosicion){
        posicion = nuevaPosicion;
    }

    public Posicion obtenerPosicion(){
        return posicion;
    }
}
