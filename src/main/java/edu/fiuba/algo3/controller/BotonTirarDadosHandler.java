package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.oldView.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.Objects;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final AlgoRoma JUEGO;
    private final TableroView TABLERO;

    private final static MediaPlayer dados = new MediaPlayer(new Media(Objects.requireNonNull(Objects.requireNonNull(BotonTirarDadosHandler.class.getResource("/musica/dice.mp3")).toExternalForm())));

    public BotonTirarDadosHandler(Stage stage, AlgoRoma juego, TableroView tablero) {
        this.STAGE = stage;
        this.JUEGO = juego;
        this.TABLERO = tablero;
    }

    void reproducirDados() {
        dados.play();
        dados.seek(dados.getStartTime());
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        reproducirDados();
        JUEGO.jugarTurno();
        if (JUEGO.tieneGanador()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fin del juego");
            alert.setHeaderText("El ganador es " + JUEGO.obtenerGanador().getNombre());
            alert.setContentText("¡Felicitaciones!");

            ButtonType botonSalir = new ButtonType("Salir");
            alert.getButtonTypes().setAll(botonSalir);
            alert.showAndWait();
            STAGE.close();
        } else {
            TABLERO.actualizarMovimientos();
        }
    }
}
