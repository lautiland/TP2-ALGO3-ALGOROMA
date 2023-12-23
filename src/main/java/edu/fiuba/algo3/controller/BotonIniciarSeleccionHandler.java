package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.scenes.CantidadJugadoresScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.Objects;

public class BotonIniciarSeleccionHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final AlgoRoma JUEGO;
    private final static MediaPlayer sonido = new MediaPlayer(new Media(Objects.requireNonNull(Objects.requireNonNull(BotonTirarDadosHandler.class.getResource("/musica/select.mp3")).toExternalForm())));


    public BotonIniciarSeleccionHandler(Stage stage, AlgoRoma juego) {
        this.STAGE = stage;
        this.JUEGO = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonido.play();
        CantidadJugadoresScene seleccion = new CantidadJugadoresScene(STAGE, JUEGO);
        STAGE.setScene(seleccion.getScene());
        STAGE.setMaximized(true);
    }
}
