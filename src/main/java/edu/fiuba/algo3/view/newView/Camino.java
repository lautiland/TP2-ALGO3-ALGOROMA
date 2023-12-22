package edu.fiuba.algo3.view.newView;

import edu.fiuba.algo3.view.oldView.View;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Camino implements ObserverCamino {
    private static final int CELL_SIZE = 50;
    private final List<Gladiador> gladiadores = new ArrayList<>();
    private static final HashMap<String, String> gladiadorAImagen = new HashMap<>();

    public Camino(List<String> nombresGladiadores) {
        int numeroDeGladiador = 0;
        for (String gladiadorNombre : nombresGladiadores) {
            numeroDeGladiador++;
            this.gladiadores.add(new Gladiador(gladiadorNombre, numeroDeGladiador));
            gladiadorAImagen.put(gladiadorNombre, "/gladiador/gladiador" + numeroDeGladiador + ".png");
        }
    }
    public Camino (){}
    @Override
    public void actualizar(String nombreGladiador, int numeroDeCasillaX, int numeroDeCasillaY) {
        for (Gladiador gladiador : gladiadores) {
            if (gladiador.getModelNombre().equals(nombreGladiador)) {
                gladiador.mover(numeroDeCasillaX, numeroDeCasillaY);
            }
        }
    }
    public void paint(GridPane gridPane) {
        for (Gladiador gladiador : gladiadores) {
            String url = gladiadorAImagen.get(gladiador.getModelNombre());
            Image image = new Image(Objects.requireNonNull(View.class.getResource(url)).toExternalForm());
            ImageView imageView = new ImageView();
            imageView.setFitWidth(CELL_SIZE);
            imageView.setFitHeight(CELL_SIZE);
            imageView.setImage(image);
            VBox vBox = new VBox();
            vBox.getChildren().add(imageView);
            gridPane.add(vBox, gladiador.getPosicionX(), gladiador.getPosicionY());
        }
    }
}
