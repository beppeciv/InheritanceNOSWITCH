package org.example.alphamodel.risorse;


import org.example.alphamodel.SmistamentoProducible;
import org.example.alphamodel.risorse.Producible;

public enum Resource implements Producible {
        COIN,STONE,SERVANT,SHIELD;

    @Override
    public void mproducible(SmistamentoProducible s) {
s.dowithproducible(this);
    }
}
