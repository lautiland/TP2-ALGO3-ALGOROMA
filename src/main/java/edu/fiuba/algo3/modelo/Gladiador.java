package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamiento.Equipo;
import edu.fiuba.algo3.modelo.equipamiento.SinEquipo;
import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Lesionado;
import edu.fiuba.algo3.modelo.estado.Sano;
import edu.fiuba.algo3.modelo.nivel.Nivel;
import edu.fiuba.algo3.modelo.nivel.Novato;

public class Gladiador {

    private int energia = 20;
    private Nivel nivel;
    private Estado estado;

    private String nombre;

    //como no tiene efecto el historial de obtenciones de equipo por parte del jugador, simplemente tiene el ultimo equipo obtenido
    private Equipo equipo;
    private int turnosJugados = 0;

    public Gladiador(String nombre) {
        this.nivel = new Novato();
        this.equipo = new SinEquipo();
        this.estado = new Sano();
        this.nombre = nombre;
    }

    public void turnoEn(TableroB t) {
        this.estado = this.estado.jugar(this, t);
    }

    public void actualizarEquipo() {
        this.equipo = this.equipo.actualizar();
    }

    public void beber(int puntosPerdidos) {
        this.energia -= puntosPerdidos;
    }

    public void esAtacado() {
        this.equipo.resistirAtaque(this);
    }

    public void comer(int puntosGanados) {
        this.energia += puntosGanados;
    }

    public void esLesionado() {
        this.estado = new Lesionado();
    }

    public boolean tenesEsteEquipo(Equipo e) {
        return this.equipo.equals(e);
    }

    public boolean tenesPuntosDeEnegia(int puntos) {
        return this.energia == puntos;
    }

    public boolean tenesElNivel(Nivel n) {
        return this.nivel.equals(n);
    }

    public String obtenerNombre() {
        return "nombre";
    }

    public void actualizarPuntosSegunNivel() {
        turnosJugados += 1;
        this.nivel = this.nivel.actualizarPuntos(this, this.turnosJugados);
    }

    public void sumarEnergia(int cantidad) {
        this.energia += cantidad;
    }

    public void restarEnegia(int cantidad) {
        this.energia -= cantidad;
    }

    public boolean sinEnergia() {
        return this.energia <= 0;
    }

    public boolean conEnergia() {
        return this.energia >= 0;
    }

}
