package org.example.alphamodel.parser;

import com.google.gson.annotations.SerializedName;
import org.example.alphamodel.risorse.CardColor;
import org.example.alphamodel.risorse.Resource;


public class LeaderGson {
    private int id;
    private int victoryPoints;
    @SerializedName("type")
    private String type;
    @SerializedName("quantitycolor")
    private CardColor[] quantitycolor;
    @SerializedName("discount")
    private Resource discount;
    @SerializedName("quantityresource")
    private Resource[] quantityresource;
    @SerializedName("extendedspace")
    private Resource[] bonuspace;
    @SerializedName("resources")
    private Resource production;
    @SerializedName("cardcolor")
    private CardColor cardcolor;
    @SerializedName("cardlevel")
    private int level;
    @SerializedName("requiredresource")
    private Resource reqresource;

    public int getId() {
        return id;
    }
    public int getVictorypoints() {
        return victoryPoints;
    }

    public String getType() {
        return type;
    }

    public CardColor[] getQuantitycolor() {
        return quantitycolor;
    }

    public Resource getDiscount() {
        return discount;
    }

    public Resource[] getQuantityresource() {
        return quantityresource;
    }

    public Resource[] getBonuspace() {
        return bonuspace;
    }

    public Resource getProduction() {
        return production;
    }

    public CardColor getCardcolor() {
        return cardcolor;
    }

    public int getLevel() {
        return level;
    }

    public Resource getReqresource() {
        return reqresource;
    }
}
