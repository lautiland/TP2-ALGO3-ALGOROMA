package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Casco implements Equipamiento {

    @Override
    public void resistir(Energia e) {
        e.sumarPuntos(5);
    }

    @Override
    public void agregarEquipo(ArrayList<Equipamiento> equipos) {
        equipos.add(new Armadura());
    }


}
