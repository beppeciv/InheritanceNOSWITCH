package org.example.alphamodel.cards;

import org.example.alphamodel.SmistamentoLeader;
import org.example.alphamodel.risorse.CardColor;
import org.example.alphamodel.risorse.Resource;


public class LeaderProductionAndStep implements LeaderCard{
    private int id;
    private int victorypoints;
    private CardColor cardcolor;
    private int level;
    private Resource reqresource;

    public LeaderProductionAndStep(int id, int victorypoints, CardColor cardcolor, int level, Resource reqresource) {
        this.id = id;
        this.victorypoints = victorypoints;
        this.cardcolor = cardcolor;
        this.level = level;
        this.reqresource = reqresource;
    }

    @Override
    public void mleaderDispacth(SmistamentoLeader smistamentoLeader) {
        smistamentoLeader.doWithLeaderCard(this);
    }
}
