package org.example.alphamodel.market;

import org.example.alphamodel.cards.LeaderMarbleWhiteProduction;
import org.example.alphamodel.risorse.Resource;

public enum MarbleProd implements Marble {

    Bmarble(Resource.SHIELD),
    Gmarble(Resource.STONE),
    Pmarble(Resource.SERVANT),
    Ymarble(Resource.COIN);
   // Wmarble(null);

    private final Resource resource;
    private String color;

    MarbleProd(Resource resource) {
        this.resource = resource;

    }

    public Resource getResource() {
        return resource;
    }

    @Override
    public void dispatch(PlayerDispach playerDispach) {
        playerDispach.domarble(this);
    }

    @Override
    public void dispatchleader(LeaderMarbleWhiteProduction leaderMarbleWhiteProduction) {
        leaderMarbleWhiteProduction.leaderdomarble(this);
    }
}


