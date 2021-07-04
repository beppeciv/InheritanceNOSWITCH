package org.example.alphamodel.cards;

import org.example.alphamodel.risorse.CardColor;
import org.example.alphamodel.risorse.Producible;
import org.example.alphamodel.risorse.ResourceQuantity;
import org.example.alphamodel.risorse.CardColor;


public class DevCardCli {


        private final ResourceQuantity[] cardCost;
        private final CardColor cardColor;
        private final int cardTier;
        private final ResourceQuantity[] requiredProdResources;
        //private final List<Producible> willProduce;
        private final Producible[] willProduce;

    public Producible[] getWillProduce() {
        return willProduce;
    }

    private final int id;
        private final int victoryPoints;


        /** A development card alternative representation used for visual purposes
         * @param cardCost
         * @param color
         * @param cardTier
         * @param requiredProdResources
         * @param willProduce
         * @param victoryPoints
         * @param id
         */
        public DevCardCli(ResourceQuantity[] cardCost, CardColor color, int cardTier, ResourceQuantity[] requiredProdResources,
                /*List<Producible> willProduce, */
                           Producible[] willProduce,

                          int victoryPoints, int id) {
            this.cardCost = cardCost;
            this.cardColor = color;
            this.cardTier = cardTier;
            this.requiredProdResources = requiredProdResources;
            this.willProduce = willProduce;
            this.victoryPoints = victoryPoints;
            this.id=id;
        }

    public DevCardCli(ResourceQuantity[] cardCost, CardColor color, int cardTier, ResourceQuantity[] requiredProdResources,
            /*List<Producible> willProduce, */
                       Producible[] willProduceA, Producible[] willProduceB,

                      int victoryPoints, int id) {
        this.cardCost = cardCost;
        this.cardColor = color;
        this.cardTier = cardTier;
        this.requiredProdResources = requiredProdResources;
        this.victoryPoints = victoryPoints;
        this.id=id;
        int len=willProduceA.length+willProduceB.length;
        this.willProduce=new Producible[len];
        for (int k=0;k<willProduceA.length;k++) this.willProduce[k]= willProduceA[k];
        for (int k=willProduceA.length;k<len;k++) this.willProduce[k]= willProduceB[k- willProduceA.length];
    }

    public ResourceQuantity[] getCardCost() {
        return cardCost;
    }

    public int getId() {
        return id;
    }
}
