package org.example.alphamodel.market;


import org.example.alphamodel.market.Marble;
import org.example.alphamodel.market.MarbleProd;
import org.example.alphamodel.market.MarbleStep;

public interface PlayerDispach {
    void genericmarble(Marble emarble);
    void domarble(MarbleProd emarbleProd);
    void domarble(MarbleStep emarbleStep);
    void domarble(MarbleWhite emarbleWhite);
}
