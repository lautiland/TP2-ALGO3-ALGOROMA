package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonSiguienteJugadorHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final AlgoRoma juego;
    private final TableroView tableroView;

    public BotonSiguienteJugadorHandler(Stage stage, AlgoRoma juego, TableroView tableroView) {
        this.stage = stage;
        this.juego = juego;
        this.tableroView = tableroView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        tableroView.actualizarTablero();
    }
}
