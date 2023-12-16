package edu.fiuba.algo3.view.oldView;

import edu.fiuba.algo3.controller.BotonCantidadJugadorHandler;
import edu.fiuba.algo3.model.AlgoRoma;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeleccionView extends View {
    private final Stage STAGE;
    private final Scene SCENE;
    private final VBox LAYOUT;
    private final AlgoRoma JUEGO;

    public SeleccionView(Stage stage, AlgoRoma juego) {
        this.STAGE = stage;
        this.LAYOUT = new VBox(SPACING);
        LAYOUT.setAlignment(Pos.CENTER);
        this.JUEGO = juego;

        configurarContenido();
        configurarBackground(LAYOUT);

        SCENE = new Scene(LAYOUT, WIDTH, HEIGHT);
    }

    public void configurarContenido() {
        HBox subLayout = new HBox(SPACING);
        subLayout.setAlignment(Pos.CENTER);

        configurarTexto();
        configurarBotones(subLayout);

        LAYOUT.getChildren().add(subLayout);
    }

    public void configurarTexto() {
        Label texto = new Label("Seleccione la cantidad de jugadores");
        configurarTitulo(texto, TXT_FONT, TITULO_FS);
        LAYOUT.getChildren().add(texto);
    }

    public void configurarBotones(HBox subLayout) {
        for (int i = 2; i <= 6; i++) {
            Button boton = new Button(Integer.toString(i));
            configurarBoton(boton);
            boton.setOnAction(new BotonCantidadJugadorHandler(STAGE, i, JUEGO));
            subLayout.getChildren().add(boton);
        }
    }

    public Scene getScene() {
        return SCENE;
    }
}
