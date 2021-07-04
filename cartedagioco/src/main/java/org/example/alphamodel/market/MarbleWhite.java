package org.example.alphamodel.market;

import org.example.alphamodel.cards.LeaderMarbleWhiteProduction;

public enum MarbleWhite implements Marble{
    Wmarble;

    /// DO Nothing
    @Override
    public void dispatch(PlayerDispach playerDispach) {
    }
    public void dispatchleader(LeaderMarbleWhiteProduction leaderMarbleWhiteProduction) {
        leaderMarbleWhiteProduction.leaderdomarble(this);}
}
