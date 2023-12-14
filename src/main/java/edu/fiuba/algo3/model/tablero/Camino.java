package edu.fiuba.algo3.model.tablero;

import edu.fiuba.algo3.model.Gladiador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Camino {

    private final List<Casilla> SENDERO = new ArrayList<>();
    private final Map<Gladiador, Integer> GLADIADOR_TO_NUMERO_CASILLA = new HashMap<>();
    private boolean premioReclamado = false;
    private Gladiador ganador;

    public Camino(List<Gladiador> gladiadores) {
        for (Gladiador gladiador : gladiadores) {
            GLADIADOR_TO_NUMERO_CASILLA.put(gladiador, 0);
        }
    }

    public void agregarCasilla(Casilla camino) {
        this.SENDERO.add(camino);
    }

    public void mover(Gladiador gladiador, int numeroCasillas) {
        int numeroDeCasillaActualDelGladiador = this.GLADIADOR_TO_NUMERO_CASILLA.get(gladiador);
        int nuevaUbicacion = numeroDeCasillaActualDelGladiador + numeroCasillas;
        if (nuevaUbicacion > this.SENDERO.size()) {
            nuevaUbicacion = this.SENDERO.size();
        }
        this.desplazarGladiadorEInteractuar(gladiador, nuevaUbicacion);
    }

    public boolean estaEl(Gladiador gladiador, int enCasillaNumero) {
        try {
            return this.GLADIADOR_TO_NUMERO_CASILLA.get(gladiador) == enCasillaNumero;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    private void desplazarGladiadorEInteractuar(Gladiador gladiador, int nuevaUbicacion) {
        Casilla casilla;
        try {
            casilla = this.SENDERO.get(nuevaUbicacion);
        } catch (IndexOutOfBoundsException e) {
            casilla = this.SENDERO.get(this.SENDERO.size() - 1);
        }
        GLADIADOR_TO_NUMERO_CASILLA.put(gladiador, nuevaUbicacion);
        casilla.interactuarCon(gladiador, this);

    }

    public int obtenerPosicionDe(Gladiador gladiador) {
        return this.GLADIADOR_TO_NUMERO_CASILLA.get(gladiador);
    }

    public void moverAMitad(Gladiador gladiador) {
        this.desplazarGladiadorEInteractuar(gladiador, this.SENDERO.size() / 2);
    }

    public void eliminarGladiadorDeCamino(Gladiador gladiador) {
        this.GLADIADOR_TO_NUMERO_CASILLA.remove(gladiador);
    }

    public void reclamarPremio(Gladiador gladiador) {
        this.premioReclamado = true;
        this.ganador = gladiador;
    }

    public boolean tieneGanador() {
        return this.premioReclamado;
    }

    public Gladiador obtenerGanador() {
        return this.ganador;
    }
}

