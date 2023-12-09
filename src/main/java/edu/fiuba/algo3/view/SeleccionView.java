package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonCantidadJugadorHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeleccionView extends View {

    private final Scene scene;

    public SeleccionView(Stage stage) {
        VBox layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        configurarContenido(stage, layout);
        configurarBackground(layout);

        scene = new Scene(layout, WIDTH, HEIGHT);
    }

    public void configurarContenido(Stage stage, VBox layout) {
        HBox contenido = new HBox(SPACING);
        contenido.setAlignment(Pos.CENTER);

        configurarTexto(layout);
        configurarBotones(contenido, stage);

        layout.getChildren().add(contenido);
    }

    public void configurarTexto(VBox layout) {
        Label texto = new Label("Seleccione la cantidad de jugadores");
        configurarTitulo(texto, TXT_FONT, TITULO_FS);
        layout.getChildren().add(texto);
    }

    public void configurarBotones(HBox layout, Stage stage) {
        for (int i = 2; i <= 6; i++) {
            Button boton = new Button(Integer.toString(i));
            configurarBoton(boton);
            boton.setOnAction(new BotonCantidadJugadorHandler(stage, i));
            layout.getChildren().add(boton);
        }
    }
    public Scene getScene() {
        return scene;
    }
}
