package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.JugadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonCantidadJugadorHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final int cantidadJugadores;
    private final AlgoRoma juego;

    public BotonCantidadJugadorHandler(Stage stage, int cantidadJugadores, AlgoRoma juego) {
        this.stage = stage;
        this.cantidadJugadores = cantidadJugadores;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        JugadoresView jugadores = new JugadoresView(stage, cantidadJugadores, juego);
        stage.setScene(jugadores.getScene());
        stage.setMaximized(true);
    }
}

