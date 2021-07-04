package org.example.alphamodel.strongbox;

import org.example.alphamodel.risorse.Resource;

public class DepoBonus {
    private boolean[] activate;
    private int[] depo;

public  DepoBonus() {
    activate=new boolean[Resource.values().length];
    depo=new int[Resource.values().length];

}

public void add(Resource elem){
    if(activate[elem.ordinal()] && depo[elem.ordinal()]<2) depo[elem.ordinal()]++;
}

    public void setActivate(Resource elem) {
        activate[elem.ordinal()]=true;
    }

    public int[] getDepo() {
        return depo;
    }
    public boolean[] getActivate(){
    return activate;
    }
}
