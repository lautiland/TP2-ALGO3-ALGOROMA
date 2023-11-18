package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.premio.equipamiento.Equipo;
import edu.fiuba.algo3.premio.equipamiento.SinEquipo;
import edu.fiuba.algo3.modelo.nivel.Nivel;
import edu.fiuba.algo3.modelo.nivel.Novato;

public class Gladiador {

    private Energia energia;
    private Nivel nivel;
    private int posicionTablero;

    //como no tiene efecto el historial de obtenciones de equipo por parte del jugador, simplemente tiene el ultimo equipo obtenido
    private Equipo equipo;
    private int turnosJugados = 0;

    public Gladiador() {
        this.energia = new Energia();
        this.setNivel(new Novato());
        this.equipo = new SinEquipo();
    }

    public void setNivel(Nivel n) {
        this.nivel = n;
        this.nivel.setGladiador(this);
    }

    public void jugar() {
        this.turnosJugados += 1;
        this.nivel.actualizarPuntos(this.energia, this.turnosJugados);
    }

    public void actualizarEquipo() {
        this.equipo = this.equipo.actualizar();
    }

    public void esAtacado() {
        this.equipo.resistirAtaque(this.energia);
    }

    public void comer() {
        this.energia.sumarPuntos(10);
    }

    public boolean tenesEsteEquipo(Equipo e) {
        return this.equipo.equals(e);
    }

    public boolean tenesPuntosDeEnegia(int puntos) {
        return this.energia.tenes(puntos);
    }

    public Nivel getNivel() {
        return this.nivel;
    }

    public String obtenerNombre() {
        return "nombre";
    }
}
