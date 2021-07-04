package org.example.alphamodel.market;

import org.example.alphamodel.cards.LeaderMarbleWhiteProduction;

public enum MarbleStep implements Marble {
        Rmarble ;


        @Override
        public void dispatch(PlayerDispach playerDispach) {
            playerDispach.domarble(this);
        }

    @Override
        public void dispatchleader(LeaderMarbleWhiteProduction leaderMarbleWhiteProduction) {
            leaderMarbleWhiteProduction.leaderdomarble(this);
    }
}

