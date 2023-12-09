package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.JugadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        JugadoresView jugadores = new JugadoresView(stage, cantidadJugadores);
        stage.setScene(jugadores.getScene());
    }
}

