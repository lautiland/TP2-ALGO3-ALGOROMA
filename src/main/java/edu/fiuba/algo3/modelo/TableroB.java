package edu.fiuba.algo3.modelo;

import java.util.*;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.camino.CaminoFactory;
import edu.fiuba.algo3.modelo.camino.CaminoTipo;

public class TableroB {

    private final ArrayList<ArrayList<Casilla>> casillas;
    private final Map<Integer, Casilla> camino;
    private final Map<Gladiador, Integer> posicionGladiadiores;

    public TableroB(List<Gladiador> gladiadores, List<JsonObject> mapa) {
        this.casillas = new ArrayList<>();
        this.camino = new HashMap<>();
        this.posicionGladiadiores = new HashMap<>();
        //crearTablero(mapa);
        asignarPosicionesDe(gladiadores);
    }

    public void mover(Gladiador g, int a) {
        int nuevaUbicacion = posicionGladiadiores.get(g) + a;
        posicionGladiadiores.put(g, nuevaUbicacion) ;
        camino.get(nuevaUbicacion).aplicarEfecto(g);
    }

    public boolean estaEl(Gladiador g, int en) {
        return this.posicionGladiadiores.get(g) == en;
    }

    private void asignarPosicionesDe(List<Gladiador> g) {
        for (Gladiador gladiador: g) {
            posicionGladiadiores.put(gladiador, 0);
        }
    }

    /*private void crearTablero(List<JsonObject> mapa) {
        int y = 0;
        ArrayList<Casilla> fila = new ArrayList<>();
        for (JsonObject dato: mapa) {
            Efecto efecto = EfectoFactory.crearEfecto(dato.get("efecto").toString().replaceAll("^\"|\"$", ""));
            boolean esCamino = dato.get("esCamino").getAsBoolean();;
            CaminoTipo tipo = CaminoFactory.crearTipo(esCamino);
            Casilla casilla = new Casilla(efecto, tipo);
            if (esCamino)
                camino.put(dato.get("ordenRecorrido").getAsInt(), casilla);

            if (dato.get("y").getAsInt() == y) {
                fila.add(casilla);
            }
            else {
                casillas.add(fila);
                fila = new ArrayList<>();
                fila.add(casilla);
                y = dato.get("y").getAsInt();
            }
        }
    }*/
}
