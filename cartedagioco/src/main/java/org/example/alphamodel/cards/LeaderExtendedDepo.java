package org.example.alphamodel.cards;

import org.example.alphamodel.SmistamentoLeader;
import org.example.alphamodel.risorse.Resource;

public class LeaderExtendedDepo implements LeaderCard{
    private int id;
    private int victorypoints;
    private Resource[] quantityresource;
    private Resource[] bonuspace;

    public LeaderExtendedDepo(int id, int victorypoints, Resource[] quantityresource, Resource[] bonuspace) {
        this.id = id;
        this.victorypoints = victorypoints;
        this.quantityresource = quantityresource;
        this.bonuspace = bonuspace;
    }

    @Override
    public void mleaderDispacth(SmistamentoLeader smistamentoLeader) {
smistamentoLeader.doWithLeaderCard(this);
    }

    public Resource[] getBonuspace() {
        return bonuspace;
    }
}
