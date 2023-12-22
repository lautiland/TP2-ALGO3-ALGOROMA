package edu.fiuba.algo3.view.modelview;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Objects;

public class Casilla implements Celda {
    private static final int CELL_SIZE = 50;
    private static final Image PASTO_IMAGE = new Image(Objects.requireNonNull(Casilla.class.getResource("/tile/pasto_tile.png")).toExternalForm());
    private static final Image ROCA_IMAGE = new Image(Objects.requireNonNull(Casilla.class.getResource("/tile/roca_tile.png")).toExternalForm());
    private static final Image LLEGADA_IMAGE = new Image(Objects.requireNonNull(Casilla.class.getResource("/tile/llegada_tile.png")).toExternalForm());
    private static final Image SALIDA_IMAGE = new Image(Objects.requireNonNull(Casilla.class.getResource("/tile/salida_tile.png")).toExternalForm());
    private static final HashMap<String, Image> TIPO_DE_CELDA_A_IMAGEN = new HashMap<>();
    private final String TIPO_DE_CELDA;
    private final Obstaculo OBSTACULO;
    private final Premio PREMIO;

    static {
        TIPO_DE_CELDA_A_IMAGEN.put("salida", SALIDA_IMAGE);
        TIPO_DE_CELDA_A_IMAGEN.put("llegada", LLEGADA_IMAGE);
        TIPO_DE_CELDA_A_IMAGEN.put("camino", ROCA_IMAGE);
        TIPO_DE_CELDA_A_IMAGEN.put("noCamino", PASTO_IMAGE);
    }

    public Casilla(String tipoDeCelda, Obstaculo obstaculo, Premio premio) {
        this.TIPO_DE_CELDA = tipoDeCelda;
        this.OBSTACULO = obstaculo;
        this.PREMIO = premio;

        //TODO: hacer que se agreguen las imagenes de los interactuables automaticamente
    }
    public Casilla() {
        this.TIPO_DE_CELDA = "NO_CAMINO";
        this.OBSTACULO = new Obstaculo();
        this.PREMIO = new Premio();
    }

    public StackPane paint() {
        StackPane stackPane = new StackPane();
        ImageView imagenViewCasilla = new ImageView();
        imagenViewCasilla.setFitWidth(CELL_SIZE);
        imagenViewCasilla.setFitHeight(CELL_SIZE);
        imagenViewCasilla.setImage(TIPO_DE_CELDA_A_IMAGEN.get(TIPO_DE_CELDA));
        stackPane.getChildren().add(imagenViewCasilla);
        OBSTACULO.paint(stackPane);
        PREMIO.paint(stackPane);

        return stackPane;
    }
}
