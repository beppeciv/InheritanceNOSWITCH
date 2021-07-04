package org.example.gestionecoitipi.tipi;

import org.example.M;
import org.example.gestionecoitipi.gestore.GestoreGenerico;

public class TipoB extends TipoGenerico {
    @Override
    public void tun(GestoreGenerico a) {
        M.stp("sono un tipo più specifico  TIPO B");
        a.gestionespecifica(this);
    }
    public void specifictipoA(){

    }
}