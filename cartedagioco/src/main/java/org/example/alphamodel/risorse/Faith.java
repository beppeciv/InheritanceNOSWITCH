package org.example.alphamodel.risorse;

import org.example.alphamodel.SmistamentoProducible;

public enum Faith implements Producible {
FAITH;

    @Override
    public void mproducible(SmistamentoProducible s) {
        s.dowithproducible(this);
    }
}
