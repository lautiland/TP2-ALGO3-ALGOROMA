package edu.fiuba.algo3.model.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.model.excepciones.JSONInvalido;

import java.io.Reader;

public class JSONReader {

    private static JsonObject validarJSON(JsonElement jsonElement) throws JSONInvalido {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        if (!jsonObject.has("mapa")) {
            throw new JSONInvalido();
        }
        JsonObject mapa = jsonObject.getAsJsonObject("mapa");
        if (!mapa.has("ancho") || !mapa.has("largo")) {
            throw new JSONInvalido();
        }

        if (!jsonObject.has("camino")) {
            throw new JSONInvalido();
        }
        JsonObject camino = jsonObject.getAsJsonObject("camino");
        if (!camino.has("celdas")) {
            throw new JSONInvalido();
        }

        JsonArray celdas = camino.getAsJsonArray("celdas");
        for (JsonElement celda : celdas) {
            if (!celda.isJsonObject()) {
                throw new JSONInvalido();
            }
            JsonObject celdaObject = celda.getAsJsonObject();
            if (!celdaObject.has("x") || !celdaObject.has("y")) {
                throw new JSONInvalido();
            }
        }

        return jsonObject;
    }

    public static DataClassTablero obtenerMapaDesdeJson(Reader reader) {
        JsonElement jsonElement = JsonParser.parseReader(reader);

        JsonObject jsonObject = validarJSON(jsonElement);

        DataClassTablero dataTablero = obtenerTamanioMapa(jsonObject);

        obtenerCamino(jsonObject, dataTablero);
        return dataTablero;
    }

    private static DataClassTablero obtenerTamanioMapa(JsonObject jsonObject) {
        JsonObject mapaObject = jsonObject.getAsJsonObject("mapa");

        int ancho = mapaObject.getAsJsonPrimitive("ancho").getAsInt();
        int largo = mapaObject.getAsJsonPrimitive("largo").getAsInt();
        return new DataClassTablero(ancho, largo);
    }

    private static void obtenerCamino(JsonObject jsonObject, DataClassTablero dataTablero) {
        JsonObject caminoObject = jsonObject.getAsJsonObject("camino");
        JsonArray celdasArray = caminoObject.getAsJsonArray("celdas");

        for (JsonElement celdaElement : celdasArray) {
            if (celdaElement.isJsonObject()) {
                JsonObject celdaObject = celdaElement.getAsJsonObject();
                int x = celdaObject.get("x").getAsInt();
                int y = celdaObject.get("y").getAsInt();
                String premioString = obtenerValorSinComillas(celdaObject.get("premio"));
                String obstaculoString = obtenerValorSinComillas(celdaObject.get("obstaculo"));
                DataClassCelda celdaCamino = new DataClassCelda(x, y, premioString, obstaculoString);
                dataTablero.agregarCelda(celdaCamino);
            }
        }
    }


    private static String obtenerValorSinComillas(JsonElement jsonElement) {
        return jsonElement.toString().replaceAll("^\"|\"$", "");
    }
}

