package org.example.alphamodel;

import org.example.alphamodel.risorse.Faith;
import org.example.alphamodel.risorse.Producible;
import org.example.alphamodel.risorse.Resource;

public interface SmistamentoProducible {
    void m1(Producible producible);
    void dowithproducible(Resource resource);
    void dowithproducible(Faith faith);
}
