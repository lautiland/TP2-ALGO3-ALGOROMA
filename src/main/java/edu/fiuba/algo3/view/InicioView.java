package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonIniciarSeleccionHandler;
import edu.fiuba.algo3.controller.BotonSalirHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InicioView extends View {
    private final Scene scene;

    public InicioView(Stage stage) {
        VBox layout = new VBox(SPACING);
        layout.setAlignment(Pos.CENTER);

        configurarTituloPrincipal(layout);
        configurarBotones(layout, stage);
        configurarBackground(layout);

        scene = new Scene(layout, WIDTH, HEIGHT);
    }

    private void configurarTituloPrincipal(VBox layout) {
        Label titleText = new Label("AlgoRoma");
        configurarTitulo(titleText, TITULO_PRINCIPAL_FONT, TITULO_PRINCIPAL_FS);
        layout.getChildren().add(titleText);
    }

    private void configurarBotones(VBox layout, Stage stage) {

        Button iniciar = new Button("Iniciar");
        configurarBoton(iniciar);
        iniciar.setOnAction(new BotonIniciarSeleccionHandler(stage));

        Button salida = new Button("Salir");
        configurarBoton(salida);
        salida.setOnAction(new BotonSalirHandler());

        layout.getChildren().addAll(iniciar, salida);
    }

    public Scene getScene() {
        return scene;
    }
}
