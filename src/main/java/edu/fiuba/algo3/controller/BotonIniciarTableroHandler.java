package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.view.modelview.Camino;
import edu.fiuba.algo3.view.modelview.Gladiador;
import edu.fiuba.algo3.view.scenes.TableroScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        List<String> nombresGladiadores = new ArrayList<>();
        Gladiador gladiadorObserver = new Gladiador();
        for (TextField input : INPUTS) {
            String nombreGladiador = input.getText();
            JUEGO.agregarGladiador(nombreGladiador, gladiadorObserver);
            nombresGladiadores.add(nombreGladiador);
        }
        Camino observerCamino = new Camino(nombresGladiadores);
        try {
            JUEGO.iniciarJuegoCompleto("mapa.json", observerCamino);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TableroScene tablero = new TableroScene(STAGE, JUEGO, observerCamino, gladiadorObserver);
        STAGE.setScene(tablero.getScene());
    }
}
