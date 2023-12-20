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
    protected static final HashMap<String, String> INTERACTUABLE_A_IMAGEN = new HashMap<>();
    public Interactuable(String nombreInteractuable) {
        String nombreTemp  = nombreInteractuable;
        String imagen = "/interactuable/" + nombreInteractuable + ".png";
        File file = new File(imagen);
        if (!file.exists()) {
            nombreTemp = "SinInteraccion";
        }
        this.NOMBRE_INTERACTUABLE = nombreTemp;
        if (!INTERACTUABLE_A_IMAGEN.containsKey(nombreInteractuable) || !nombreInteractuable.equals("SinInteraccion")){
            INTERACTUABLE_A_IMAGEN.put(nombreInteractuable, imagen);
        }

    }
    public Interactuable() {
        this.NOMBRE_INTERACTUABLE = "SinInteraccion";
    }
    public void paint(StackPane stackPane) {
        System.out.println(NOMBRE_INTERACTUABLE);
        ImageView interactuableView = new ImageView();
        String imagenInteractuableString = INTERACTUABLE_A_IMAGEN.get(NOMBRE_INTERACTUABLE);
        Image imagenInteractuable = new Image(Objects.requireNonNull(Interactuable.class.getResource(imagenInteractuableString)).toExternalForm());
        interactuableView.setFitWidth(INTERACUABLE_SIZE);
        interactuableView.setFitHeight(INTERACUABLE_SIZE);
        interactuableView.setImage(imagenInteractuable);
        stackPane.getChildren().addAll(interactuableView);
        this.agregarInteractuable(stackPane, interactuableView);
    }

    abstract void agregarInteractuable(StackPane stackPane, ImageView interactuableView);
}
