package edu.fiuba.algo3.view.newView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public abstract class Interactuable {
    protected final int INTERACUABLE_SIZE = 32;
    protected final String NOMBRE_INTERACTUABLE;
    protected static final HashMap<String, Image> INTERACTUABLE_A_IMAGEN = new HashMap<>();
    public Interactuable(String nombreInteractuable) {
        String nombreTemp  = nombreInteractuable;
        String imagen = "/interactuable/" + nombreInteractuable + ".png";
        if (Interactuable.class.getResource(imagen) == null) {
            nombreInteractuable = "SinInteraccion";
            imagen = "/interactuable/" + nombreInteractuable + ".png";
        } else {
            if (!INTERACTUABLE_A_IMAGEN.containsKey(nombreInteractuable) || !nombreInteractuable.equals("SinInteraccion")){
                INTERACTUABLE_A_IMAGEN.put(nombreInteractuable, new Image(Objects.requireNonNull(Interactuable.class.getResource(imagen)).toExternalForm()));
            }
        }
        this.NOMBRE_INTERACTUABLE = nombreTemp;
    }
    public Interactuable() {
        this.NOMBRE_INTERACTUABLE = "SinInteraccion";
    }
    public void paint(StackPane stackPane) {
        if (!NOMBRE_INTERACTUABLE.equals("SinInteraccion")) {
            ImageView interactuableView = new ImageView();
            Image imagenInteractuable = INTERACTUABLE_A_IMAGEN.get(NOMBRE_INTERACTUABLE);
            interactuableView.setFitWidth(INTERACUABLE_SIZE);
            interactuableView.setFitHeight(INTERACUABLE_SIZE);
            interactuableView.setImage(imagenInteractuable);
            this.agregarInteractuable(stackPane, interactuableView);
            stackPane.getChildren().add(interactuableView);
        }
    }

    abstract void agregarInteractuable(StackPane stackPane, ImageView interactuableView);
    //TODO: acá se usa el patrón template method
}
