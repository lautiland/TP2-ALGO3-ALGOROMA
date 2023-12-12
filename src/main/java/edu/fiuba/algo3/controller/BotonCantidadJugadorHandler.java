package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.JugadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonCantidadJugadorHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final int CANTIDAD_JUGADORES;
    private final AlgoRoma JUEGO;

    public BotonCantidadJugadorHandler(Stage stage, int cantidadJugadores, AlgoRoma juego) {
        this.STAGE = stage;
        this.CANTIDAD_JUGADORES = cantidadJugadores;
        this.JUEGO = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        JugadoresView jugadores = new JugadoresView(STAGE, CANTIDAD_JUGADORES, JUEGO);
        STAGE.setScene(jugadores.getScene());
        STAGE.setMaximized(true);
    }
}

