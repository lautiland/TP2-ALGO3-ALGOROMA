package edu.fiuba.algo3.view.newView;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Premio extends Interactuable{
    public Premio(String nombrePremio) {
        super(nombrePremio);
    }
    public Premio() {
        super();
    }
    @Override
    void agregarInteractuable(StackPane stackPane, ImageView premioView) {
        StackPane.setAlignment(premioView, Pos.TOP_LEFT);
    }
}
