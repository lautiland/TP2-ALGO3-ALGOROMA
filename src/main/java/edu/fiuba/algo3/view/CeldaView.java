package edu.fiuba.algo3.view;

import edu.fiuba.algo3.model.tablero.Celda;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.Objects;

public class CeldaView extends View {
    public static HBox generarVista(Celda celda) {
        HBox layout = new HBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();

        ImageView background = new ImageView();
        background.setFitWidth(CELL_SIZE);
        background.setFitHeight(CELL_SIZE);

        if (celda.equals("vacio")) {
            // Cargar la imagen de pasto_tile.png para celda blanca
            Image pastoImage = new Image(Objects.requireNonNull(CeldaView.class.getResource("/pasto_tile.png")).toExternalForm());
            background.setImage(pastoImage);
        } else {
            // Cargar la imagen de roca_tile.png para celda negra
            Image rocaImage = new Image(Objects.requireNonNull(CeldaView.class.getResource("/roca_tile.png")).toExternalForm());
            background.setImage(rocaImage);
        }

        stackPane.getChildren().addAll(background);

        ImageView premio = new ImageView();
        premio.setFitWidth(24);
        premio.setFitHeight(24);
        premio.setImage(new Image(Objects.requireNonNull(CeldaView.class.getResource("/" + celda.nombrePremio().toLowerCase() + ".png")).toExternalForm()));
        stackPane.getChildren().addAll(premio);

        ImageView obstaculo = new ImageView();
        obstaculo.setFitWidth(24);
        obstaculo.setFitHeight(24);
        obstaculo.setImage(new Image(Objects.requireNonNull(CeldaView.class.getResource("/" + celda.nombreObstaculo().toLowerCase() + ".png")).toExternalForm()));
        stackPane.getChildren().addAll(obstaculo);

        StackPane.setAlignment(premio, Pos.TOP_LEFT);
        StackPane.setAlignment(obstaculo, Pos.BOTTOM_RIGHT);

        layout.getChildren().addAll(stackPane);

        return layout;
    }
}
