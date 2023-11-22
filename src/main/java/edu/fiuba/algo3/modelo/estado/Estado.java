package edu.fiuba.algo3.modelo.estado;

import edu.fiuba.algo3.modelo.Gladiador;
import edu.fiuba.algo3.modelo.TableroB;

public interface Estado {

    Estado jugar(Gladiador g, TableroB t);
}
