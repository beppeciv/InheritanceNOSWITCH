package org.example.alphamodel.cards;

import org.example.alphamodel.SmistamentoLeader;
import org.example.alphamodel.risorse.CardColor;
import org.example.alphamodel.risorse.Resource;


public class LeaderDiscount implements LeaderCard{
    private int id;
    private int victorypoints;
    private CardColor[] quantitycolor;
    private Resource discount;

    public LeaderDiscount(int id, int victorypoints, CardColor[] quantitycolor, Resource discount) {
        this.id = id;
        this.victorypoints = victorypoints;
        this.quantitycolor = quantitycolor;
        this.discount = discount;
    }

    @Override
    public void mleaderDispacth(SmistamentoLeader smistamentoLeader) {
smistamentoLeader.doWithLeaderCard(this);

    }

    public Resource getDiscount() {
        return discount;
    }
}
