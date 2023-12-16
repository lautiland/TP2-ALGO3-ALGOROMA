package edu.fiuba.algo3.view.newView;

import java.util.HashMap;
import java.util.List;

public class Gladiador {
    private int cantidadDeGladiadores;
    private static final HashMap<edu.fiuba.algo3.model.Gladiador, String> gladiadorAImagen = new HashMap<>();    //acá se guardan las imagenes de los gladiadores
    public Gladiador(List<edu.fiuba.algo3.model.Gladiador> gladiadores) {
        this.cantidadDeGladiadores = 0;
        for (edu.fiuba.algo3.model.Gladiador gladiador : gladiadores) {
            agregarGladiador(gladiador);
        }
    }
    private void agregarGladiador(edu.fiuba.algo3.model.Gladiador gladiador) {
        cantidadDeGladiadores++;
        gladiadorAImagen.put(gladiador, "/gladiador/gladiador" + cantidadDeGladiadores + ".png");
    }
    public static String paint(edu.fiuba.algo3.model.Gladiador model) {
        return gladiadorAImagen.get(model);
    }
}

