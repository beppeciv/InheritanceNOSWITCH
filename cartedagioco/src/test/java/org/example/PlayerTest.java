package org.example;
import org.example.alphamodel.Path;
import org.example.alphamodel.Player;
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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testMercato() {
        StrongBox strongBox=new StrongBox();
        Path path=new Path();
        Depo depo=new Depo();
        Player player=new Player(strongBox,path,depo);
        Marble[] buffermarble=new Marble[4];
        buffermarble[0]= MarbleProd.Bmarble;
        buffermarble[1]= MarbleStep.Rmarble;
        buffermarble[2]= MarbleWhite.Wmarble;
        buffermarble[3]= MarbleProd.Ymarble;
        //attivare la produzione delle carte sviluppo
        for (Marble px:buffermarble)
            player.genericmarble(px);
        int[] rich=depo.getRicchezza();
        assertEquals(1, rich[Resource.COIN.ordinal()]);
        assertEquals(1, rich[Resource.SHIELD.ordinal()]);
        assertEquals(0, rich[Resource.STONE.ordinal()]);
        assertEquals(0, rich[Resource.SERVANT.ordinal()]);
        assertEquals(1, path.getPlayerpos());

    }
    @Test
    public void testCarteSviluppo() {
        StrongBox strongBox=new StrongBox();
        Path path=new Path();
        Depo depo=new Depo();
        Player player=new Player(strongBox,path,depo);
        DevCardCli[] dev= StreamBuilderForGson.initDevCard();
        Producible[] p=dev[35].getWillProduce();
        System.out.println(p.length);

        //attivare la produzione delle carte sviluppo
        for (Producible px:p) {
            //player.dowithproducible(px); non funziona
            player.m1(px);
        }
        player.stampa();

        int[] rich=strongBox.getRicchezza();
        assertEquals(0, rich[Resource.COIN.ordinal()]);
        assertEquals(0, rich[Resource.SHIELD.ordinal()]);
        assertEquals(0, rich[Resource.STONE.ordinal()]);
        assertEquals(3, rich[Resource.SERVANT.ordinal()]);
        assertEquals(2, path.getPlayerpos());
    }
    @Test
    public void testCarteLeader() {
        StrongBox strongBox=new StrongBox();
        Path path=new Path();
        Depo depo=new Depo();
        Player player=new Player(strongBox,path,depo);
        LeaderCard[] leaderCards=StreamBuilderForGson.initLeaderCard();
        Marble[] buffermarble=new Marble[4];
        buffermarble[0]= MarbleProd.Bmarble;
        buffermarble[1]= MarbleStep.Rmarble;
        buffermarble[2]= MarbleWhite.Wmarble;
        buffermarble[3]= MarbleProd.Ymarble;

        CardColor[] cardColors=new CardColor[3];
        cardColors[0]=CardColor.GREEN;
        cardColors[1]=CardColor.GREEN;
        cardColors[2]=CardColor.PURPLE;
        LeaderMarbleWhiteProduction leaderMarbleWhiteProduction=new LeaderMarbleWhiteProduction(5, 3, cardColors, Resource.STONE);
        for (Marble px:buffermarble)
            player.msmistamentoleader(
                    leaderMarbleWhiteProduction);
                         //   .leadergenericmarble(px)
            //);

    }
    @Test
    public void testbufferPruductionandleaderWhite() {
        StrongBox strongBox=new StrongBox();
        Path path=new Path();
        Depo depo=new Depo();
        Player player=new Player(strongBox,path,depo);
        LeaderCard[] leaderCards=StreamBuilderForGson.initLeaderCard();
        Marble[] buffermarble=new Marble[4];
        buffermarble[0]= MarbleProd.Bmarble;
        buffermarble[1]= MarbleStep.Rmarble;
        buffermarble[2]= MarbleWhite.Wmarble;
        buffermarble[3]= MarbleProd.Ymarble;
        int[] rich=depo.getRicchezza();
        player.setTemporarybuffer(buffermarble);

        assertEquals(1, rich[Resource.COIN.ordinal()]);
        assertEquals(1, rich[Resource.SHIELD.ordinal()]);
        assertEquals(0, rich[Resource.STONE.ordinal()]);
        assertEquals(0, rich[Resource.SERVANT.ordinal()]);
        assertEquals(1, path.getPlayerpos());


        player.msmistamentoleader(leaderCards[8]);
        assertEquals(1, rich[Resource.SERVANT.ordinal()]);
        player.msmistamentoleader(leaderCards[9]);

        /// leader has effect only once
        assertFalse(2== rich[Resource.SHIELD.ordinal()]);
    }

    @Test
    public void buywithdiscount() {
        StrongBox strongBox=new StrongBox();
        Path path=new Path();
        Depo depo=new Depo();
        Player player=new Player(strongBox,path,depo);
        DevCardCli[] dev=StreamBuilderForGson.initDevCard();
        LeaderCard[] leaderCards=StreamBuilderForGson.initLeaderCard();
        strongBox.add(Resource.SERVANT);
        //strongBox.add(Resource.SERVANT);
        assertFalse(player.attempttobuydevcard(dev[1]));
        player.msmistamentoleader(leaderCards[1]);

        assertTrue(player.getDevownesd().get(0).getId()==2);
       // assertEquals(1, rich[Resource.SERVANT.ordinal()]);
      //  player.msmistamentoleader(leaderCards[9]);

        /// leader has effect only once
        //assertFalse(2== rich[Resource.SHIELD.ordinal()]);


    }

    @Test
    public void bproductionandStep() {
        StrongBox strongBox=new StrongBox();
        Path path=new Path();
        Depo depo=new Depo();
        Player player=new Player(strongBox,path,depo);
        DevCardCli[] dev=StreamBuilderForGson.initDevCard();
        LeaderCard[] leaderCards=StreamBuilderForGson.initLeaderCard();
        strongBox.add(Resource.SERVANT);
        player.setOptionalresource(Resource.COIN);
        player.msmistamentoleader(leaderCards[15]);
        assertEquals(1, path.getPlayerpos());
        int[] rich=strongBox.getRicchezza();
        assertEquals(1, rich[Resource.COIN.ordinal()]);
        assertEquals(0, rich[Resource.SHIELD.ordinal()]);
        assertEquals(0, rich[Resource.STONE.ordinal()]);
        assertEquals(1, rich[Resource.SERVANT.ordinal()]);




    }
    @Test
    public void depobonus() {
        StrongBox strongBox=new StrongBox();
        Path path=new Path();
        Depo depo=new Depo();
        Player player=new Player(strongBox,path,depo);
        DevCardCli[] dev=StreamBuilderForGson.initDevCard();
        LeaderCard[] leaderCards=StreamBuilderForGson.initLeaderCard();
        strongBox.add(Resource.SERVANT);
        player.setOptionalresource(Resource.COIN);

        DepoBonus depoBonus=player.getDepoBonus();
        int[] extendeddepo=depoBonus.getDepo();
        boolean[] activated=depoBonus.getActivate();
        assertFalse(activated[0]);
        assertFalse(activated[1]);
        assertFalse(activated[2]);
        assertFalse(activated[3]);

        player.msmistamentoleader(leaderCards[6]);


        assertTrue(activated[Resource.SHIELD.ordinal()]);
        assertFalse(activated[Resource.COIN.ordinal()]);
        assertFalse(activated[Resource.SERVANT.ordinal()]);
        assertFalse(activated[Resource.STONE.ordinal()]);

    }




}
