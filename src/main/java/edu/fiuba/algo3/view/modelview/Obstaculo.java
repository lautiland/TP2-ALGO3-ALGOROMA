package edu.fiuba.algo3.view.modelview;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Obstaculo extends Interactuable {
    public Obstaculo(String nombreObstaculo) {
        super(nombreObstaculo.isEmpty() ? "sininteraccion" : nombreObstaculo);
    }

    public Obstaculo() {
        super("sininteraccion");
    }

    @Override
    void agregarInteractuable(StackPane stackPane, ImageView obstaculoView) {
        StackPane.setAlignment(obstaculoView, Pos.BOTTOM_RIGHT);
    }
}
