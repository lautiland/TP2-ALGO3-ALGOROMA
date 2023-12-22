package edu.fiuba.algo3.view.modelview;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Camino implements ObserverCamino {
    private final List<UbicacionGladiador> gladiadores = new ArrayList<>();
    private static final HashMap<String, String> gladiadorAImagen = new HashMap<>();

    public Camino(List<String> nombresGladiadores) {
        int numeroDeGladiador = 0;
        for (String gladiadorNombre : nombresGladiadores) {
            numeroDeGladiador++;
            this.gladiadores.add(new UbicacionGladiador(gladiadorNombre));
            gladiadorAImagen.put(gladiadorNombre, "/gladiador/gladiador" + numeroDeGladiador + ".png");
        }
    }

    public Camino() {
    }

    @Override
    public void actualizar(String nombreGladiador, int numeroDeCasillaX, int numeroDeCasillaY) {
        for (UbicacionGladiador gladiador : gladiadores) {
            if (gladiador.getModelNombre().equals(nombreGladiador)) {
                gladiador.mover(numeroDeCasillaX, numeroDeCasillaY);
            }
        }
    }

    public void paint(GridPane gridPane) {
        for (UbicacionGladiador gladiador : gladiadores) {
            gladiador.paint(gridPane, gladiadorAImagen.get(gladiador.getModelNombre()));
        }
    }
}
