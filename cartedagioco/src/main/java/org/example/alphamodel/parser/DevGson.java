package org.example.alphamodel.parser;

import com.google.gson.annotations.SerializedName;
import org.example.alphamodel.risorse.CardColor;
import org.example.alphamodel.risorse.Faith;
import org.example.alphamodel.risorse.Resource;
import org.example.alphamodel.risorse.ResourceQuantity;


public class DevGson {

    private ResourceQuantity[] cardCost;
    private CardColor cardColor;
    private int cardTier;
    private ResourceQuantity[] requiredProdResources;

    @SerializedName("type")
    private String type;
    @SerializedName("resource")
    private Resource[] ricchezza;
    @SerializedName("fede")
    private Faith[] valore;
    private int id;
    private int victoryPoints;

    public ResourceQuantity[] getCardCost() {return cardCost;}
    public CardColor getCardColor() {return cardColor;}
    public int getCardTier() {return cardTier;}
    public ResourceQuantity[] getRequiredProdResources() {return requiredProdResources;}
    public int getId() {return id;}
    public Resource[] getRicchezza() {
        return ricchezza;
    }

    public Faith[] getValore() {
        return valore;
    }
    public int getVictoryPoints() {return victoryPoints;}
    public String getType(){return type;}
    }


