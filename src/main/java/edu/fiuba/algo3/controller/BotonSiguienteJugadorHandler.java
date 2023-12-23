package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.scenes.TableroScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class BotonSiguienteJugadorHandler implements EventHandler<ActionEvent> {
    private final TableroScene tableroScene;
    private final static MediaPlayer sonido = new MediaPlayer(new Media(Objects.requireNonNull(Objects.requireNonNull(BotonTirarDadosHandler.class.getResource("/musica/select.mp3")).toExternalForm())));


    public BotonSiguienteJugadorHandler(TableroScene tableroScene) {
        this.tableroScene = tableroScene;
    }

    private void reproducirSonido() {
        sonido.play();
        sonido.seek(sonido.getStartTime());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        reproducirSonido();
        tableroScene.actualizarSiguienteTurno();
    }
}
