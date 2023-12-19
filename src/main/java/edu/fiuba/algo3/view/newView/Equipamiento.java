package edu.fiuba.algo3.view.newView;

import javafx.scene.image.Image;

import java.io.File;
import java.util.HashMap;

public class Equipamiento implements ObserverEquipamiento {
    private static edu.fiuba.algo3.model.equipamiento.Equipamiento equipamientoActual;
    private static final HashMap<String, String> EQUIPAMIENTO_A_IMAGEN = new HashMap<>();    //acá se guardan las imagenes de los equipamientos
    private void agregarEquipamiento(String equipamiento) {
        String imagen = "/equipamiento/" + equipamiento + ".png";
        File file = new File(imagen);
        if (!file.exists()) {
            imagen = "/equipamiento/sinEquipamiento.png";
        }
        EQUIPAMIENTO_A_IMAGEN.put(equipamiento, imagen);

    }
    @Override
    public void actualizar(edu.fiuba.algo3.model.equipamiento.Equipamiento equipamiento) {
        equipamientoActual = equipamiento;
        agregarEquipamiento(equipamiento.getClass().getSimpleName().toLowerCase());
    }
    public static Image paint() {
        return new Image(EQUIPAMIENTO_A_IMAGEN.get(equipamientoActual.getClass().getSimpleName().toLowerCase()));
    }
}
