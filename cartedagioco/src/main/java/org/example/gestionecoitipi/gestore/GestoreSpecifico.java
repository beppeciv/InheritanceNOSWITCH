package org.example.gestionecoitipi.gestore;

import org.example.M;
import org.example.gestionecoitipi.tipi.TipoA;
import org.example.gestionecoitipi.tipi.TipoB;
import org.example.gestionecoitipi.tipi.TipoGenerico;

public class GestoreSpecifico extends GestoreGenerico {
    public void gestioneGenerico(TipoGenerico tipo){tipo.tun(this);M.stp("sono evento A"); }
    public void gestionespecifica(TipoA a){ M.stp("gestione specifica A ");}
    public void gestionespecifica(TipoB b){ M.stp("gestione specifica B");}
}
