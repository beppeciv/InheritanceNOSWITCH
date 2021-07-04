package org.example.alphamodel.strongbox;

import org.example.alphamodel.risorse.Resource;

public class Depo {
    private int[] ricchezza;
// to be real depo not a copy of strongbog
    public Depo() {
        ricchezza = new int[Resource.values().length];
    }
    public void add(Resource elem){
        ricchezza[elem.ordinal()]++;
    }

    public int[] getRicchezza() {
        return ricchezza;
    }
}
