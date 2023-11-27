package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.excepciones.Ganador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Camino {

    private final List<Casilla> sendero = new ArrayList<>();
    private final Map<Gladiador, Integer> punterosDeGladiadoresANumeroDeCasilla = new HashMap<>();



    public Camino(List<Gladiador> gladiadores) {
        inicializarPosicionesDeGladiadores(gladiadores);
    }

    public void agregarCasilla(Casilla c) {
        this.sendero.add(c);
    }

    public void mover(Gladiador gladiador, int casillas) {
        int numeroDeCasillaActualDelGladiador = this.punterosDeGladiadoresANumeroDeCasilla.get(gladiador);
        int nuevaUbicacion = numeroDeCasillaActualDelGladiador + casillas;
        this.desplazarGladiadorEInteractuar(gladiador, nuevaUbicacion);
    }

    public boolean estaEl(Gladiador g, int enCasillaNumero) {
        return this.punterosDeGladiadoresANumeroDeCasilla.get(g) == enCasillaNumero;
    }

    private void inicializarPosicionesDeGladiadores(List<Gladiador> gladiadores) {
        for (Gladiador gladiador: gladiadores) {
            punterosDeGladiadoresANumeroDeCasilla.put(gladiador, 0);
        }
    }

    private void desplazarGladiadorEInteractuar(Gladiador gladiador, int nuevaUbicacion) {
        try {
            Casilla casilla = this.sendero.get(nuevaUbicacion);
            punterosDeGladiadoresANumeroDeCasilla.put(gladiador, nuevaUbicacion);
            casilla.interactuarCon(gladiador);
        } catch (IndexOutOfBoundsException e) {
            gladiador.abrirPuerta(this);
        }

    }
    public void moverAMitad(Gladiador g) {
        this.desplazarGladiadorEInteractuar(g, this.sendero.size()/2);
    }

    public void eliminarPuntero(Gladiador g) {
        this.punterosDeGladiadoresANumeroDeCasilla.remove(g);
    }
}

