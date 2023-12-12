package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.SeleccionView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonIniciarSeleccionHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final AlgoRoma JUEGO;

    public BotonIniciarSeleccionHandler(Stage stage, AlgoRoma juego) {
        this.STAGE = stage;
        this.JUEGO = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SeleccionView seleccion = new SeleccionView(STAGE, JUEGO);
        STAGE.setScene(seleccion.getScene());
        STAGE.setMaximized(true);
    }
}
