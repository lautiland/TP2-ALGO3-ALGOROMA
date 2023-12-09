package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.AlgoRoma;
import edu.fiuba.algo3.model.Dado;
import edu.fiuba.algo3.model.Gladiador;
import edu.fiuba.algo3.view.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class BotonIniciarTableroHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final ArrayList<TextField> inputs;

    public BotonIniciarTableroHandler(ArrayList<TextField> inputs, Stage stage) {
        this.stage = stage;
        this.inputs = inputs;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ArrayList<Gladiador> gladiadores = new ArrayList<>();
        for (TextField input : inputs) {
            String nombre = input.getText();
            gladiadores.add(new Gladiador(nombre, new Dado()));
        }
        AlgoRoma juego = new AlgoRoma();
        try {
            juego.iniciarJuegoCompleto("mapa.json", gladiadores);
        } catch (IOException e) {
            System.out.println("Error al cargar el mapa");
        }
        TableroView tablero = new TableroView(stage, juego);
        stage.setScene(tablero.getScene());
    }
}
