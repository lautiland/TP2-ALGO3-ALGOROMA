package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class BotonSiguienteJugadorHandler implements EventHandler<ActionEvent> {
    private final TableroView tableroView;
    private final static MediaPlayer sonido = new MediaPlayer(new Media(Objects.requireNonNull(Objects.requireNonNull(BotonTirarDadosHandler.class.getResource("/select.mp3")).toExternalForm())));


    public BotonSiguienteJugadorHandler(TableroView tableroView) {
        this.tableroView = tableroView;
    }

    private void reproducirSonido() {
        sonido.play();
        sonido.seek(sonido.getStartTime());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        reproducirSonido();
        tableroView.actualizarTablero();
    }
}
