package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.SeleccionView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonIniciarSeleccionHandler implements EventHandler<ActionEvent> {
    private final Stage stage;

    public BotonIniciarSeleccionHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SeleccionView seleccion = new SeleccionView(stage);
        stage.setScene(seleccion.getScene());
    }
}
