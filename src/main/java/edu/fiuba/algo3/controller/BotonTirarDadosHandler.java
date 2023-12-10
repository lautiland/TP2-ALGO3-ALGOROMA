package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final AlgoRoma juego;
    private final TableroView tablero;

    public BotonTirarDadosHandler(Stage stage, AlgoRoma juego, TableroView tablero) {
        this.stage = stage;
        this.juego = juego;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.jugarTurno();
        if (juego.obtenerTablero().tieneGanador()) {
            // stage.setScene(new GanadorView(stage, juego.obtenerGanador()).getScene());
        } else {
            tablero.actualizarMovimientos();
        }
    }
}
