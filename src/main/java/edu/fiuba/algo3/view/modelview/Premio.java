package edu.fiuba.algo3.view.modelview;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Premio extends Interactuable {
    public Premio(String nombrePremio) {
        super(nombrePremio.isEmpty() ? "sininteraccion" : nombrePremio);
    }

    public Premio() {
        super("sininteraccion");
    }

    @Override
    void agregarInteractuable(StackPane stackPane, ImageView premioView) {
        StackPane.setAlignment(premioView, Pos.TOP_LEFT);
    }
}
