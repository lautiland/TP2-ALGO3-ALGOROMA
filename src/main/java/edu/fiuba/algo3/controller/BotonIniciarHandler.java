package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.SeleccionView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonIniciarHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final AlgoRoma juego;

    public BotonIniciarHandler(Stage stage, AlgoRoma juego) {
        this.stage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SeleccionView seleccion = new SeleccionView(stage, juego);
        stage.setScene(seleccion.getScene());
    }
}
