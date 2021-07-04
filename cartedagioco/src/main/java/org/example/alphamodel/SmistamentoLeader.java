package org.example.alphamodel;

import org.example.alphamodel.cards.*;
import org.example.alphamodel.risorse.Faith;
import org.example.alphamodel.risorse.Producible;
import org.example.alphamodel.risorse.Resource;

public interface SmistamentoLeader {
    void msmistamentoleader(LeaderCard leaderCard);
    void doWithLeaderCard(LeaderDiscount leaderDiscount);
    void doWithLeaderCard(LeaderExtendedDepo leaderExtendedDepo);
    void doWithLeaderCard(LeaderMarbleWhiteProduction leaderMarbleWhiteProduction);
    void doWithLeaderCard(LeaderProductionAndStep leaderProductionAndStep);
}
