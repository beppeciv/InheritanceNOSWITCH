package org.example.gestionecoitipi.tipi;

import org.example.gestionecoitipi.gestore.GestoreGenerico;
import org.example.M;

public class TipoA extends TipoGenerico {
    @Override
    public void tun(GestoreGenerico a) {
        M.stp("sono un tipo più specifico  TIPO A");
        a.gestionespecifica(this);
    }
    public void specifictipoA(){

    }
}
