package edu.fiuba.algo3.modelo;

import javafx.geometry.Pos;

import java.util.ArrayList;

public class Gladiador {
    private String nombre;
    private Energia energia;
    private ArrayList<Equipamiento> equipamientos;

    public Gladiador(String nombre, Energia energia){
        this.nombre = nombre;
        this.energia = energia;
        this.equipamientos = new ArrayList<Equipamiento>();
    }

    public ArrayList<Equipamiento> obtenerEquipamiento(){
        return equipamientos;
    }

    public Energia obtenerEnergia(){
        return energia;
    }

    public void recibirDanio(){
        for(Equipamiento equipamiento: equipamientos){
            equipamiento.recibirDanio();
        }

        energia.restarPuntos();
    }

    public String obtenerNombre(){
        return nombre;
    }
}
