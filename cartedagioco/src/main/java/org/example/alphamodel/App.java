package org.example.alphamodel;

import org.example.alphamodel.cards.DevCardCli;
import org.example.alphamodel.cards.LeaderCard;
import org.example.alphamodel.cards.LeaderMarbleWhiteProduction;
import org.example.alphamodel.market.Marble;
import org.example.alphamodel.market.MarbleProd;
import org.example.alphamodel.market.MarbleStep;
import org.example.alphamodel.market.MarbleWhite;
import org.example.alphamodel.parser.StreamBuilderForGson;
import org.example.alphamodel.risorse.CardColor;
import org.example.alphamodel.risorse.Producible;
import org.example.alphamodel.risorse.Resource;
import org.example.alphamodel.strongbox.Depo;
import org.example.alphamodel.strongbox.DepoBonus;
import org.example.alphamodel.strongbox.StrongBox;

public class App {
    public static void main(String[] args) {


        StrongBox strongBox=new StrongBox();
        Path path=new Path();
        Depo depo=new Depo();
Player player=new Player(strongBox,path,depo);
        DevCardCli[] dev= StreamBuilderForGson.initDevCard();

Producible[] p=dev[35].getWillProduce();
System.out.println(p.length);
    for (Producible px:p) {
        //player.dowithproducible(px); non funziona
    player.m1(px);
    }
player.stampa();


    LeaderCard[] leaderCards=StreamBuilderForGson.initLeaderCard();


    StrongBox strongBox1=new StrongBox();
    Path path1=new Path();
    Depo depo1=new Depo();
    Player player1=new Player(strongBox1,path1,depo1);
    LeaderCard[] leaderCards1=StreamBuilderForGson.initLeaderCard();
    Marble[] buffermarble=new Marble[4];

    buffermarble[0]= MarbleProd.Bmarble;
    buffermarble[1]= MarbleStep.Rmarble;
    buffermarble[2]= MarbleWhite.Wmarble;
    buffermarble[3]= MarbleProd.Ymarble;

    CardColor[] cardColors=new CardColor[3];
    cardColors[0]=CardColor.GREEN;
    cardColors[1]=CardColor.GREEN;
    cardColors[2]=CardColor.PURPLE;
    player1.setTemporarybuffer(buffermarble);
    LeaderMarbleWhiteProduction leaderMarbleWhiteProduction=new LeaderMarbleWhiteProduction(8, 3, cardColors, Resource.STONE);
        //for (Marble px:buffermarble)
            player.msmistamentoleader(leaderMarbleWhiteProduction);
}
}
