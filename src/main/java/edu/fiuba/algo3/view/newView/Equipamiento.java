package edu.fiuba.algo3.view.newView;

import java.util.HashMap;
import java.util.List;

public class Equipamiento {
    private static final HashMap<edu.fiuba.algo3.model.equipamiento.Equipamiento, String> equipamientoAImagen = new HashMap<>();    //acá se guardan las imagenes de los equipamientos
    public Equipamiento(List<edu.fiuba.algo3.model.equipamiento.Equipamiento> equipamientos) {
        for (edu.fiuba.algo3.model.equipamiento.Equipamiento equipamiento : equipamientos) {
            agregarEquipamiento(equipamiento);
        }
    }
    private void agregarEquipamiento(edu.fiuba.algo3.model.equipamiento.Equipamiento equipamiento) {
        try {
            String imagen = "/equipamiento/" + equipamiento.getClass().getSimpleName().toLowerCase() + ".png";
            equipamientoAImagen.put(equipamiento, imagen);

        }catch (Exception e) {
            System.out.println("No se pudo agregar el equipamiento" + equipamiento.getClass().getSimpleName() + "a la vista, no se encontró la imagen");
        }
    }
    public static String paint(edu.fiuba.algo3.model.equipamiento.Equipamiento model) {
        return equipamientoAImagen.get(model);
    }
}
