package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class EscudoYEspada implements Equipamiento{

    @Override
    public void resistir(Energia e) {
        e.sumarPuntos(5);
    }

    @Override
    public void agregarEquipo(ArrayList<Equipamiento> e) {
        e.add(new Llave());
    }

}
