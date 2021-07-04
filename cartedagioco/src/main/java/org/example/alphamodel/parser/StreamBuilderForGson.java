package org.example.alphamodel.parser;

import com.google.gson.Gson;
import org.example.alphamodel.cards.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamBuilderForGson {

    public static String fileforGson(InputStream is) {
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = null;
        try {
            line = buf.readLine();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();

        while (line != null) {
            sb.append(line).append("\n");
            try {
                line = buf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    public static DevCardCli[] initDevCard() {
        Parsatore p = Parsatore.getInstance("devcard.json");
        Gson gson = new Gson();
        return prova(p, gson);
    }

    private static DevCardCli[] prova(Parsatore p, Gson gson) {
        DevGson[] devGsons = gson.fromJson(p.filotto(), DevGson[].class);
        DevCardCli[] dev = new DevCardCli[devGsons.length];
        for (int k = 0; k < devGsons.length; k++) {
            switch (devGsons[k].getType()) {
                case "PROD":
                    dev[k] = new DevCardCli(devGsons[k].getCardCost(), devGsons[k].getCardColor(), devGsons[k].getCardTier(), devGsons[k].getRequiredProdResources(),
                            devGsons[k].getRicchezza(),
                            devGsons[k].getVictoryPoints(), devGsons[k].getId());
                    break;
                case "FEDE":
                    dev[k] = new DevCardCli(devGsons[k].getCardCost(), devGsons[k].getCardColor(), devGsons[k].getCardTier(), devGsons[k].getRequiredProdResources(),
                            devGsons[k].getValore(),
                            devGsons[k].getVictoryPoints(), devGsons[k].getId());
                    break;
                case "MIX":
                    dev[k] = new DevCardCli(devGsons[k].getCardCost(), devGsons[k].getCardColor(), devGsons[k].getCardTier(), devGsons[k].getRequiredProdResources(),
                            devGsons[k].getRicchezza(), devGsons[k].getValore(),
                            devGsons[k].getVictoryPoints(), devGsons[k].getId());

                    break;

            }

        }
        return dev;
    }

    public static LeaderCard[] initLeaderCard() {
        Parsatore p = Parsatore.getInstance("leader.json");
        Gson gson = new Gson();
        return prova2(p, gson);
    }

    private static LeaderCard[] prova2(Parsatore p, Gson gson) {
        LeaderGson[] leaderGsons = gson.fromJson(p.filotto(), LeaderGson[].class);
        LeaderCard[] leaderCards = new LeaderCard[leaderGsons.length];
        for (int k = 0; k < leaderGsons.length; k++) {
            switch (leaderGsons[k].getType()) {
                case "QCOLDISCOUNT":
                    leaderCards[k] = new LeaderDiscount(leaderGsons[k].getId(),leaderGsons[k].getVictorypoints(),leaderGsons[k].getQuantitycolor(),leaderGsons[k].getDiscount());
                    break;
                case "RQEXTENDEDDEPO":
                    leaderCards[k] = new LeaderExtendedDepo(leaderGsons[k].getId(),leaderGsons[k].getVictorypoints(),leaderGsons[k].getQuantityresource(),leaderGsons[k].getBonuspace());
                    break;
                case "QCOLMARBLE":
                    leaderCards[k] = new LeaderMarbleWhiteProduction(leaderGsons[k].getId(),leaderGsons[k].getVictorypoints(),leaderGsons[k].getQuantitycolor(),leaderGsons[k].getProduction());
                    break;
                case "LEVELCOLBONUSPRODUCTION":
                    leaderCards[k] = new LeaderProductionAndStep(leaderGsons[k].getId(),leaderGsons[k].getVictorypoints(),leaderGsons[k].getCardcolor(),leaderGsons[k].getLevel(),leaderGsons[k].getReqresource());
                    break;
            }
        }
        return leaderCards;
    }
}