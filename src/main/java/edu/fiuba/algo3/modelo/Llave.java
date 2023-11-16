package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Llave implements Equipamiento {
    @Override
    public void resistir(Energia e) {
        e.sumarPuntos(8);
    }

    @Override
    public void agregarEquipo(ArrayList<Equipamiento> e) {

    }

}
