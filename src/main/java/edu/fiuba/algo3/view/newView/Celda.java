package edu.fiuba.algo3.view.newView;

import edu.fiuba.algo3.view.oldView.CeldaView;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Objects;

public class Celda{
    private static final Image PASTO_IMAGE = new Image(Objects.requireNonNull(CeldaView.class.getResource("/tile/pasto_tile.png")).toExternalForm());
    private static final Image ROCA_IMAGE = new Image(Objects.requireNonNull(CeldaView.class.getResource("/tile/roca_tile.png")).toExternalForm());
    private static final Image LLEGADA_IMAGE = new Image(Objects.requireNonNull(CeldaView.class.getResource("/tile/llegada_tile.png")).toExternalForm());
    private static final HashMap<edu.fiuba.algo3.model.tablero.Celda, String> celdaAImagen = new HashMap<>();


    public static String paint(edu.fiuba.algo3.model.tablero.Celda model) {
        return celdaAImagen.get(model);
    }
}
