package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final AlgoRoma JUEGO;
    private final TableroView TABLERO;

    public BotonTirarDadosHandler(Stage stage, AlgoRoma juego, TableroView tablero) {
        this.STAGE = stage;
        this.JUEGO = juego;
        this.TABLERO = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        JUEGO.jugarTurno();
        if (JUEGO.obtenerTablero().tieneGanador()) {
            //STAGE.setScene(new GanadorView(STAGE, JUEGO.obtenerGanador()).getScene());
        } else {
            TABLERO.actualizarMovimientos();
        }
    }
}
