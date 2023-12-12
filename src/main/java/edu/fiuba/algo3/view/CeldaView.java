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
    private static final Image PASTO_IMAGE = new Image(Objects.requireNonNull(CeldaView.class.getResource("/pasto_tile.png")).toExternalForm());
    private static final Image ROCA_IMAGE = new Image(Objects.requireNonNull(CeldaView.class.getResource("/roca_tile.png")).toExternalForm());
    private static final Image LLEGADA_IMAGE = new Image(Objects.requireNonNull(CeldaView.class.getResource("/llegada_tile.png")).toExternalForm());
    private static final Map<String, Image> IMAGE_CACHE = new HashMap<>();

    private Image loadImage(String path) {
        return new Image(Objects.requireNonNull(CeldaView.class.getResource(path)).toExternalForm());
    }

    private Image getCachedImage(String path) {
        return IMAGE_CACHE.computeIfAbsent(path, this::loadImage);
    }

    public HBox generarVista(Celda celda) {
        HBox layout = new HBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();

        ImageView background = new ImageView();
        background.setFitWidth(CELL_SIZE);
        background.setFitHeight(CELL_SIZE);

        String nombrePremio = celda.nombrePremio().toLowerCase();
        String nombreObstaculo = celda.nombreObstaculo().toLowerCase();

        if (celda.equals("vacio")) {
            background.setImage(PASTO_IMAGE);
        } else if (nombrePremio.equals("llegada")) {
            background.setImage(LLEGADA_IMAGE);
        } else {
            background.setImage(ROCA_IMAGE);
        }

        stackPane.getChildren().addAll(background);

        if (!nombrePremio.equals("vacio") && !nombrePremio.equals("llegada") && !nombrePremio.equals("salida")) {
            ImageView premio = new ImageView();
            premio.setFitWidth(24);
            premio.setFitHeight(24);
            Image imagenPremio = getCachedImage("/" + celda.nombrePremio().toLowerCase() + ".png");
            premio.setImage(imagenPremio);
            stackPane.getChildren().addAll(premio);
            StackPane.setAlignment(premio, Pos.TOP_LEFT);

        }

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
