package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.JugadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonCantidadJugadorHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final int cantidadJugadores;

    public BotonCantidadJugadorHandler(Stage stage, int cantidadJugadores) {
        this.stage = stage;
        this.cantidadJugadores = cantidadJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(new Scene(new JugadoresView(stage, cantidadJugadores), 800, 600));
    }
}

