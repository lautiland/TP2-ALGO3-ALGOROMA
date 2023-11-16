package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Gladiador {

    private Energia energia;
    private Nivel nivel;
    private int posicionTablero;
    private int turnosJugados = 0;

    public Gladiador() {
        this.energia = new Energia();
        setNivel(new Novato());
    }

    public void setNivel(Nivel n) {
        this.nivel = n;
        this.nivel.setNivel(this);
    }

    public void jugar() {
        this.turnosJugados += 1;
        this.nivel.sumarPuntos(this.energia, this.turnosJugados);
        this.nivel.verNivel();
    }




}
