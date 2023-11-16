package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Tablero {
    private final HashMap<String, Posicion> casillerosGladiadores;
    private final HashMap<Posicion, Fiera> casilleros; // Deberia ser un generico de Casillero.

    public Tablero(ArrayList<Gladiador> gladiadores, ArrayList<Fiera> fieras){
        casillerosGladiadores = new HashMap<String, Posicion>();
        casilleros = new HashMap<Posicion, Fiera>();
        for(Gladiador gladiador: gladiadores){
            casillerosGladiadores.put(gladiador.obtenerNombre(), new Posicion(0));
        }
    }

    public void avanzar(Gladiador gladiador, Dado dado){
        if(gladiador.obtenerEnergia().obtenerPuntos() == 0) return;
        int cantidadDeCasilleros = dado.tirar();
        Posicion posicionActual = casillerosGladiadores.get(gladiador.obtenerNombre());
        Fiera fiera = casilleros.get(posicionActual);
        posicionActual.avanzar(cantidadDeCasilleros);
    }
    public Posicion obtenerPosicionGladiador(Gladiador gladiador){
        return casillerosGladiadores.get(gladiador.obtenerNombre());
    }
}
