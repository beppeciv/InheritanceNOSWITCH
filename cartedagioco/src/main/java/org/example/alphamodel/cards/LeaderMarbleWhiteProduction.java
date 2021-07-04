package org.example.alphamodel.cards;

import org.example.alphamodel.SmistamentoLeader;
import org.example.alphamodel.market.Marble;
import org.example.alphamodel.market.MarbleProd;
import org.example.alphamodel.market.MarbleStep;
import org.example.alphamodel.market.MarbleWhite;

import org.example.alphamodel.risorse.CardColor;
import org.example.alphamodel.risorse.Resource;


public class LeaderMarbleWhiteProduction implements LeaderCard,LeaderMarbleDispach {
    private int id;
    private int victorypoints;
    public CardColor[] quantitycolor;
    private Resource production;

    public LeaderMarbleWhiteProduction(int id, int victorypoints,CardColor[] quantitycolor, Resource production) {
        this.id = id;
        this.victorypoints = victorypoints;
        this.quantitycolor=quantitycolor;
        this.production = production;
    }

    @Override
    public void leadergenericmarble(Marble emarble) {
emarble.dispatchleader(this);
    }

    @Override
    public void leaderdomarble(MarbleProd emarbleProd) {

    }

    @Override
    public void leaderdomarble(MarbleStep emarbleStep) {

    }

    @Override
    public void leaderdomarble(MarbleWhite emarbleWhite) {
        System.out.println("ho prodotto " + production.name());

    }

    public Resource getProduction() {
        return production;
    }

    @Override
    public void mleaderDispacth(SmistamentoLeader smistamentoLeader) {
smistamentoLeader.doWithLeaderCard(this);
    }
}
