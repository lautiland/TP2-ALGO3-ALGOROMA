package edu.fiuba.algo3.view;

import edu.fiuba.algo3.model.tablero.Celda;
import edu.fiuba.algo3.model.tablero.CeldaSinCasilla;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.Objects;

public class CeldaView extends View{
    public static HBox generarVista(Celda celda) {
        HBox layout = new HBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(CELL_SIZE);
        imageView.setFitHeight(CELL_SIZE);

        if (celda.getClass() == CeldaSinCasilla.class) {
            // Cargar la imagen de pasto_tile.png para celda blanca
            Image pastoImage = new Image(Objects.requireNonNull(CeldaView.class.getResource("/pasto_tile.png")).toExternalForm());
            imageView.setImage(pastoImage);
        } else {
            // Cargar la imagen de roca_tile.png para celda negra
            Image rocaImage = new Image(Objects.requireNonNull(CeldaView.class.getResource("/roca_tile.png")).toExternalForm());
            imageView.setImage(rocaImage);
        }

        layout.getChildren().addAll(imageView);
        return layout;
    }
}
