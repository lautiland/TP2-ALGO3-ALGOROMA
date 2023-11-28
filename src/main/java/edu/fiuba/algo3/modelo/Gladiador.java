package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamiento.Equipo;
import edu.fiuba.algo3.modelo.equipamiento.SinEquipo;
import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Lesionado;
import edu.fiuba.algo3.modelo.estado.Sano;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Gladiador {

    private final Energia energia = new Energia();
    private Seniority seniority = new Novato();
    private Estado estado = new Sano();
    public String nombre;
    private Equipo equipo = new SinEquipo();
    private final Tiradas tiradas = new Tiradas();

    public Gladiador(String nombre) {
        this.nombre = nombre;
    }

    public void jugarTurno(Camino c) {
        System.out.println("\n\nTurno " + this.nombre);
        this.estado = this.estado.jugar(this, c);
        this.tiradas.verificarLimite(this);
    }

    public void actualizarEquipo() {
        this.equipo = this.equipo.actualizar();
    }

    public void actualizarSeniority() {
        this.seniority = this.seniority.actualizar(this);
    }

    public void esAtacado() {
        this.equipo.resistirAtaque(this);
    }

    public void modificarEnergia(int puntos) {
        this.energia.modificarPuntos(puntos); ;
    }

    public void esLesionado() {
        this.estado = new Lesionado();
    }

    public int tirarDado() {
        return this.tiradas.tirarDado();
    }

    public Estado actualizarEstadoSinEnegia() {
        return this.energia.atualizarSinEnergia(this.estado);
    }

    public Estado actualzarEstadoConEnergia() {
        return this.energia.atualizarConEnergia(this.estado);
    }

    public boolean tenesEsteEquipo(Equipo e) {
        return this.equipo.equals(e);
    }

    public boolean tenesPuntosDeEnegia(int puntos) {
        return this.energia.tenes(puntos);
    }

    public void abrirPuerta(Camino c) {
        this.equipo.abrirPuerta(this, c);
    }
}
