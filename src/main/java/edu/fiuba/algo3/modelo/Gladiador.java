package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.equipamiento.SinEquipamiento;
import edu.fiuba.algo3.modelo.estado.Estado;
import edu.fiuba.algo3.modelo.estado.Lesionado;
import edu.fiuba.algo3.modelo.estado.Sano;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import edu.fiuba.algo3.modelo.tablero.Camino;

public class Gladiador {

    public final String NOMBRE;
    private final Energia ENERGIA = new Energia();
    private final Tiradas TIRADAS;
    private Estado estado = new Sano();
    private Seniority seniority = new Novato();
    private Equipamiento equipamiento = new SinEquipamiento();

    public Gladiador(String nombre, Dado dado) {
        this.TIRADAS = new Tiradas(dado);
        this.NOMBRE = nombre;
    }

    public void jugarTurno(Camino camino) {
        System.out.println("\n\nTurno " + this.NOMBRE);
        this.estado = this.estado.jugar(this, camino);
        this.TIRADAS.verificarLimite(this);
    }

    public void actualizarEquipo() {
        this.equipamiento = this.equipamiento.actualizar();
    }

    public void actualizarSeniority() {
        this.seniority = this.seniority.actualizar(this);
    }

    public void recibirAtaque() {
        this.equipamiento.resistirAtaque(this);
    }

    public void modificarEnergia(int puntos) {
        this.ENERGIA.modificarPuntos(puntos);
    }

    public void lesionar() {
        this.estado = new Lesionado();
    }

    public int calcularMovimientos() {
        return this.TIRADAS.tirarDado();
    }

    public Estado actualizarEstado() {
        return this.ENERGIA.actualizarEstado(this.estado);
    }

    public boolean tenesPuntosDeEnegia(int puntos) {
        return this.ENERGIA.tenes(puntos);
    }

    public void abrirPuerta(Camino camino) {
        this.equipamiento.abrirPuerta(this, camino);
    }
}
