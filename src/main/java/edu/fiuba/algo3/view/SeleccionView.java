package edu.fiuba.algo3.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SeleccionView extends View {
    private final Scene scene;

    public SeleccionView(Stage stage) {
        VBox layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        configurarContenido(layout);
        configurarBackground(layout, stage);

        scene = new Scene(layout, 800, 600);
    }

    public void configurarContenido(VBox layout) {
        VBox contenido = new VBox(SPACING);
        contenido.setAlignment(Pos.CENTER);

        configurarTexto(contenido);
        configurarBotones(contenido);

        layout.getChildren().add(contenido);
    }

    public void configurarTexto(VBox layout) {
        Text texto = new Text("Seleccione la cantidad de jugadores");
        VBox.setMargin(texto, new Insets(0, 0, 10, 0));
        Font titleFont = Font.loadFont(getClass().getResourceAsStream(BTN_FONT), 25);
        texto.setFont(titleFont);
        texto.setFill(Color.WHITE);
        //agrego sombra al texto para mejor visibilidad
        DropShadow sombra = new DropShadow();
        sombra.setColor(Color.BLACK);
        sombra.setRadius(9);
        sombra.setOffsetX(3);
        sombra.setOffsetY(3);
        texto.setEffect(sombra);
        layout.getChildren().add(texto);
    }

    public void configurarBotones(VBox layout) {

        HBox botonesBox = new HBox(SPACING);
        botonesBox.setAlignment(Pos.CENTER);

        for (int i = 2; i <= 6; i++) {
            ToggleButton boton = new ToggleButton(Integer.toString(i));
            configurarBoton(boton);
            botonesBox.getChildren().add(boton);
        }

        layout.getChildren().add(botonesBox);
    }

    public Scene getScene() {
        return scene;
    }
}
