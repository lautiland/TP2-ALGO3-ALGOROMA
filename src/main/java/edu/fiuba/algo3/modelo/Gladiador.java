package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Gladiador {

    private Energia energia;
    private Nivel nivel;
    private int posicionTablero;

    private ArrayList<Equipamiento> equipamientos;
    private int turnosJugados = 0;

    public Gladiador() {
        this.energia = new Energia();
        this.setNivel(new Novato());
        this.equipamientos = new ArrayList<>();
    }

    public void setNivel(Nivel n) {
        this.nivel = n;
        this.nivel.setGladiador(this);
    }

    public void jugar() {
        this.turnosJugados += 1;
        this.nivel.sumarPuntos(this.energia, this.turnosJugados);
    }

    public void recibirPremio() {
        if (this.equipamientos.isEmpty())
            this.equipamientos.add(new Casco());
        else {
            Equipamiento ultimoEquipo = this.equipamientos.get(this.equipamientos.size()-1);
            ultimoEquipo.agregarEquipo(this.equipamientos);
        }
    }

    public void esAtacado() {
        energia.restarPuntos(20);
        for (Equipamiento equipo : this.equipamientos) {
            equipo.resistir(this.energia);
        }
    }

    public Equipamiento getUltimoEquipo() {
        return this.equipamientos.get(this.equipamientos.size()-1);
    }

    public Energia getEnergia() {
        return this.energia;
    }

}
