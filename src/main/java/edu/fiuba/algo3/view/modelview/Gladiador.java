package edu.fiuba.algo3.view.modelview;

import edu.fiuba.algo3.view.scenes.SceneUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class Gladiador extends SceneUtil implements ObserverGladiador {
    private static final double MULTIPLICADOR_TAMANIO = 2;
    private String nombre;
    private int energia;
    private String equipamiento;

    @Override
    public void actualizar(String nombre, int energia, String equipamiento) {
        this.nombre = nombre;
        this.energia = energia;
        this.equipamiento = equipamiento;
    }

    public void paint(BorderPane LAYOUT) {
        HBox grillaInfo = new HBox();
        grillaInfo.setAlignment(Pos.CENTER);
        LAYOUT.setTop(null);
        grillaInfo.getChildren().clear();
        grillaInfo.setAlignment(Pos.CENTER);
        VBox subGrilla = new VBox(SPACING);
        subGrilla.setPadding(new Insets(0, 2 * CELL_SIZE, 0, 0));
        subGrilla.setAlignment(Pos.CENTER);

        Label jugadorLabel = new Label(nombre);
        Label energiaLabel = new Label("Energía: " + energia);
        configurarTitulo(jugadorLabel, TITULO_PRINCIPAL_FONT, TITULO_FS);
        configurarTitulo(energiaLabel, TXT_FONT, TITULO_FS);
        Image imagenEquip = new Image(Objects.requireNonNull(SceneUtil.class.getResource("/equipamiento/" + equipamiento + ".png")).toExternalForm());
        ImageView imageViewEquip = new ImageView(imagenEquip);
        imageViewEquip.setFitHeight(CELL_SIZE * MULTIPLICADOR_TAMANIO);
        imageViewEquip.setFitWidth(CELL_SIZE * MULTIPLICADOR_TAMANIO);


        subGrilla.getChildren().addAll(jugadorLabel, energiaLabel);
        grillaInfo.getChildren().add(subGrilla);
        grillaInfo.getChildren().addAll(imageViewEquip);
        grillaInfo.setPadding(new Insets(CELL_SIZE, 0, 0, 0));
        LAYOUT.setTop(grillaInfo);
    }
}
