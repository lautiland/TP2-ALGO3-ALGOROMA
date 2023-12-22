package edu.fiuba.algo3.view.modelview;

import edu.fiuba.algo3.view.scenes.SceneUtil;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class UbicacionGladiador extends SceneUtil {
    private final String modelName;
    private int posicionX;
    private int posicionY;

    public UbicacionGladiador(String gladiadorNombre) {
        modelName = gladiadorNombre;
    }

    public String getModelNombre() {
        return modelName;
    }

    public void mover(int numeroDeCasillaX, int numeroDeCasillaY) {
        posicionX = numeroDeCasillaX;
        posicionY = numeroDeCasillaY;
    }

    void paint(GridPane gridPane, String url) {
        Image image = new Image(Objects.requireNonNull(SceneUtil.class.getResource(url)).toExternalForm());
        ImageView imageView = new ImageView();
        imageView.setFitWidth(CELL_SIZE);
        imageView.setFitHeight(CELL_SIZE);
        imageView.setImage(image);
        VBox vBox = new VBox();
        vBox.getChildren().add(imageView);
        gridPane.add(vBox, this.posicionX, this.posicionY);
    }
}

