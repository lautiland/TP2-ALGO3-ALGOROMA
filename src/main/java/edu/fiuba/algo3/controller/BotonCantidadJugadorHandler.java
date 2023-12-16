package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.oldView.JugadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.Objects;

public class BotonCantidadJugadorHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final int CANTIDAD_JUGADORES;
    private final AlgoRoma JUEGO;
    private final static MediaPlayer sonido = new MediaPlayer(new Media(Objects.requireNonNull(Objects.requireNonNull(BotonTirarDadosHandler.class.getResource("/musica/select.mp3")).toExternalForm())));

    public BotonCantidadJugadorHandler(Stage stage, int cantidadJugadores, AlgoRoma juego) {
        this.STAGE = stage;
        this.CANTIDAD_JUGADORES = cantidadJugadores;
        this.JUEGO = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonido.play();
        JugadoresView jugadores = new JugadoresView(STAGE, CANTIDAD_JUGADORES, JUEGO);
        STAGE.setScene(jugadores.getScene());
        STAGE.setMaximized(true);
    }
}

