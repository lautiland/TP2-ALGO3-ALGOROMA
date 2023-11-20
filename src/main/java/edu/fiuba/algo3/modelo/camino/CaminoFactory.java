package edu.fiuba.algo3.modelo.camino;

public class CaminoFactory {

    public static CaminoTipo crearTipo(Boolean esCamino) {
        if (esCamino)
            return new Camino();
        return new NoEsCamino();
    }
}
