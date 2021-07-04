package org.example.alphamodel.strongbox;

import org.example.alphamodel.risorse.Resource;

public class StrongBox {
    private int[] ricchezza;

    public StrongBox() {
        ricchezza = new int[Resource.values().length];
    }
    public void add(Resource elem){
        ricchezza[elem.ordinal()]++;
    }

    public int[] getRicchezza() {
        return ricchezza;
    }
}
