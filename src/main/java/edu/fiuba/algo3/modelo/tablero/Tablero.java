package edu.fiuba.algo3.modelo.tablero;

import java.util.*;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.excepciones.Ganador;
import edu.fiuba.algo3.modelo.interactuable.Interactuable;
import edu.fiuba.algo3.modelo.interactuable.InteractuableFactory;

public class Tablero {

    private final Celda[][] grillas;
    private final List<Casilla> recorrido = new ArrayList<>();
    private final int LARGO;
    private final int ANCHO;
    private final Camino camino;

    public Tablero(List<Gladiador> gladiadores, List<JsonObject> mapa, int largo, int ancho) {
        this.ANCHO = ancho;
        this.LARGO = largo;
        this.grillas = new Celda[this.LARGO][this.ANCHO];
        this.camino = new Camino(gladiadores);
        this.crearCaminoEnTablero(mapa);
        this.construirElResto();
    }

    public void turnoDe(Gladiador g) {
        g.jugarTurno(this.camino);
    }

    private void crearCaminoEnTablero(List<JsonObject> mapa) {
        for (JsonObject dato: mapa) {
            int x = dato.get("x").getAsInt();
            int y = dato.get("y").getAsInt();
            String premioString = dato.get("premio").toString().replaceAll("^\"|\"$", "");
            String obstaculoString = dato.get("obstaculo").toString().replaceAll("^\"|\"$", "");
            Interactuable premio = InteractuableFactory.crearInteractuable(premioString);
            Interactuable obstaculo = InteractuableFactory.crearInteractuable(obstaculoString);
            Casilla casilla = new Casilla(premio, obstaculo);
            this.recorrido.add(casilla);
            this.camino.agregarCasilla(casilla);
            this.grillas[x][y] = casilla;
        }
    }
    public void construirElResto() {
        for (int y = 0; y < this.ANCHO; y++) {
            for (int x = 0; x < this.LARGO; x++) {
                if (this.grillas[x][y] == null)
                    this.grillas[x][y] = new CeldaSinCamino();
            }
        }
    }

    public void eliminarPuntero(Gladiador g) {
        this.camino.eliminarPuntero(g);
    }
}
