package org.example;

import org.example.gestionecoitipi.gestore.GestoreGenerico;
import org.example.gestionecoitipi.gestore.GestoreSpecifico;
import org.example.gestionecoitipi.tipi.TipoA;
import org.example.gestionecoitipi.tipi.TipoB;
import org.example.gestionecoitipi.tipi.TipoGenerico;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        GestoreGenerico g=new GestoreSpecifico();
        TipoGenerico ta=new TipoA();
        TipoGenerico tb=new TipoB();
        g.gestioneGenerico(ta);
       // g.gestioneGenerico(tb);
    }
}
