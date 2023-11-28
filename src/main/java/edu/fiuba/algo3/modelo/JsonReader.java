package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonReader {

    public static DataClassTablero obtenerMapaDesdeJson(String rutaArchivoJson) throws IOException {
        try (Reader reader = new FileReader(rutaArchivoJson)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);

            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                DataClassTablero dataTablero = obtenerTamanioMapa(jsonObject);

                if (dataTablero != null) {
                    obtenerCamino(jsonObject, dataTablero);
                    return dataTablero;
                }
            }
            return null;
        }
    }

    private static DataClassTablero obtenerTamanioMapa(JsonObject jsonObject) {
        if (jsonObject.has("mapa")) {
            JsonObject mapaObject = jsonObject.getAsJsonObject("mapa");

            if (mapaObject.has("ancho") && mapaObject.has("largo")) {
                int ancho = mapaObject.getAsJsonPrimitive("ancho").getAsInt();
                int largo = mapaObject.getAsJsonPrimitive("largo").getAsInt();
                return new DataClassTablero(ancho, largo);
            }
        }
        return null;
    }

    private static void obtenerCamino(JsonObject jsonObject, DataClassTablero dataTablero) {
        if (jsonObject.has("camino")) {
            JsonObject caminoObject = jsonObject.getAsJsonObject("camino");

            if (caminoObject.has("celdas")) {
                JsonArray celdasArray = caminoObject.getAsJsonArray("celdas");

                for (JsonElement celdaElement : celdasArray) {
                    if (celdaElement.isJsonObject()) {
                        JsonObject celdaObject = celdaElement.getAsJsonObject();
                        int x = celdaObject.get("x").getAsInt();
                        int y = celdaObject.get("y").getAsInt();
                        String premioString = obtenerValorSinComillas(celdaObject.get("premio"));
                        String obstaculoString = obtenerValorSinComillas(celdaObject.get("obstaculo"));
                        DataClassCelda celdaCamino = new DataClassCelda(x, y, premioString, obstaculoString);
                        dataTablero.camino.add(celdaCamino);
                    }
                }
            }
        }
    }

    private static String obtenerValorSinComillas(JsonElement jsonElement) {
        return jsonElement.toString().replaceAll("^\"|\"$", "");
    }
}

