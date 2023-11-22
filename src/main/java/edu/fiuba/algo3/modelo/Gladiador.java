package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamiento.Equipo;
import edu.fiuba.algo3.modelo.equipamiento.SinEquipo;
import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Sano;
import edu.fiuba.algo3.modelo.nivel.Nivel;
import edu.fiuba.algo3.modelo.nivel.Novato;

public class Gladiador {

    private final Energia energia;
    private Nivel nivel;
    private Estado estado;

    //como no tiene efecto el historial de obtenciones de equipo por parte del jugador, simplemente tiene el ultimo equipo obtenido
    private Equipo equipo;
    private int turnosJugados = 0;

    public Gladiador() {
        this.energia = new Energia();
        this.nivel = new Novato();
        this.equipo = new SinEquipo();
        this.estado = new Sano();
    }

    public void jugar(TableroB t) {
        this.estado = this.estado.jugar(this, t);
    }

    public void actualizarEquipo() {
        this.equipo = this.equipo.actualizar();
    }

    public void beber(int puntosPerdidos) {
        this.energia.restarPuntos(puntosPerdidos);
    }

    public void esAtacado() {
        this.equipo.resistirAtaque(this);
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

    public boolean tenesElNivel(Nivel n) {
        return this.nivel.equals(n);
    }

    public String obtenerNombre() {
        return "nombre";
    }

    public void setEstado(Estado e) {
        this.estado = e;
    }

    public void actualizarPuntosSegunNivel() {
        turnosJugados += 1;
        this.nivel = this.nivel.actualizarPuntos(this.energia, this.turnosJugados);
    }

    public void sumarEnergia(int cantidad) {
        this.energia.sumarPuntos(cantidad);
    }

    public void restarEnegia(int cantidad) {
        this.energia.restarPuntos(cantidad);
    }

    public boolean sinEnergia() {
        return this.energia.tenesPuntosMenorA(0);
    }

    public boolean conEnergia() {
        return this.energia.tenesPuntosMayorA(0);
    }

}
