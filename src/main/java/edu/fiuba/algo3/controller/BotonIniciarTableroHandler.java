package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.oldView.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class BotonIniciarTableroHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final AlgoRoma JUEGO;
    private final ArrayList<TextField> INPUTS;
    private final static MediaPlayer sonido = new MediaPlayer(new Media(Objects.requireNonNull(Objects.requireNonNull(BotonTirarDadosHandler.class.getResource("/musica/select.mp3")).toExternalForm())));


    public BotonIniciarTableroHandler(ArrayList<TextField> inputs, Stage stage, AlgoRoma juego) {
        this.STAGE = stage;
        this.INPUTS = inputs;
        this.JUEGO = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonido.play();
        for (TextField input : INPUTS) {
            String nombre = input.getText();
            JUEGO.agregarGladiador(nombre);
        }
        try {
            JUEGO.iniciarJuegoCompleto("mapa.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TableroView tablero = new TableroView(STAGE, JUEGO);
        STAGE.setScene(tablero.getScene());
    }
}
