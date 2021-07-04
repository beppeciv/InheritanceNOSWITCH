package org.example.alphamodel.cards;

import org.example.alphamodel.market.Marble;
import org.example.alphamodel.market.MarbleProd;
import org.example.alphamodel.market.MarbleStep;
import org.example.alphamodel.market.MarbleWhite;
import org.example.alphamodel.risorse.Resource;

public interface LeaderMarbleDispach {
    void leadergenericmarble(Marble emarble);
    void leaderdomarble(MarbleProd emarbleProd);
    void leaderdomarble(MarbleStep emarbleStep);
    void leaderdomarble(MarbleWhite emarbleWhite);
}
