package edu.fiuba.algo3.view.newView;

import edu.fiuba.algo3.model.interactuable.Interactuable;
import edu.fiuba.algo3.model.interactuable.InteractuableFactory;
import edu.fiuba.algo3.model.tablero.Casilla;
import edu.fiuba.algo3.model.tablero.CeldaSinCasilla;
import edu.fiuba.algo3.view.oldView.CeldaView;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Objects;

public class Celda {
    private static final Image PASTO_IMAGE = new Image(Objects.requireNonNull(CeldaView.class.getResource("/pasto_tile.png")).toExternalForm());
    private static final Image ROCA_IMAGE = new Image(Objects.requireNonNull(CeldaView.class.getResource("/roca_tile.png")).toExternalForm());
    private static final Image LLEGADA_IMAGE = new Image(Objects.requireNonNull(CeldaView.class.getResource("/llegada_tile.png")).toExternalForm());
    private static final HashMap<edu.fiuba.algo3.model.tablero.Celda, String> celdaAImagen = new HashMap<>();    //acá se guardan las imagenes de las celdas

    public Celda() {
        Interactuable nada = InteractuableFactory.crearInteractuable("Nada");
        celdaAImagen.put(new Casilla(nada, nada), "roca_tile.png");
        celdaAImagen.put(new CeldaSinCasilla(), "pasto_tile.png");
    }

    public static String paint(edu.fiuba.algo3.model.tablero.Celda model) {
        return celdaAImagen.get(model);
    }
}
