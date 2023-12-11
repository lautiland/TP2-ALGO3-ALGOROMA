package edu.fiuba.algo3.view;

import edu.fiuba.algo3.model.tablero.Celda;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CeldaView extends View {
    private static final Image pastoImage = new Image(Objects.requireNonNull(CeldaView.class.getResource("/pasto_tile.png")).toExternalForm());
    private static final Image rocaImage = new Image(Objects.requireNonNull(CeldaView.class.getResource("/roca_tile.png")).toExternalForm());

    private static final Map<String, Image> imageCache = new HashMap<>();

    private Image loadImage(String path) {
        return new Image(Objects.requireNonNull(CeldaView.class.getResource(path)).toExternalForm());
    }

    private Image getCachedImage(String path) {
        return imageCache.computeIfAbsent(path, this::loadImage);
    }

    public HBox generarVista(Celda celda) {
        HBox layout = new HBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();

        ImageView background = new ImageView();
        background.setFitWidth(CELL_SIZE);
        background.setFitHeight(CELL_SIZE);

        if (celda.equals("vacio")) {
            // Cargar la imagen de pasto_tile.png para celda blanca
            background.setImage(pastoImage);
        } else {
            // Cargar la imagen de roca_tile.png para celda negra
            background.setImage(rocaImage);
        }

        stackPane.getChildren().addAll(background);

        String nombrePremio = celda.nombrePremio().toLowerCase();
        if (!nombrePremio.equals("vacio")) {
            ImageView premio = new ImageView();
            premio.setFitWidth(24);
            premio.setFitHeight(24);
            Image imagenPremio = getCachedImage("/" + celda.nombrePremio().toLowerCase() + ".png");
            premio.setImage(imagenPremio);
            stackPane.getChildren().addAll(premio);
            StackPane.setAlignment(premio, Pos.TOP_LEFT);

        }

        String nombreObstaculo = celda.nombreObstaculo().toLowerCase();
        if (!nombreObstaculo.equals("vacio")) {
            ImageView obstaculo = new ImageView();
            obstaculo.setFitWidth(24);
            obstaculo.setFitHeight(24);
            Image imagenObstaculo = getCachedImage("/" + celda.nombreObstaculo().toLowerCase() + ".png");
            obstaculo.setImage(imagenObstaculo);
            stackPane.getChildren().addAll(obstaculo);
            StackPane.setAlignment(obstaculo, Pos.BOTTOM_RIGHT);

        }

        layout.getChildren().addAll(stackPane);

        return layout;
    }
}
