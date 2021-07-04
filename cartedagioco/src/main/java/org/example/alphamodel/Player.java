package org.example.alphamodel;

import org.example.alphamodel.cards.*;
import org.example.alphamodel.market.*;
import org.example.alphamodel.risorse.Faith;
import org.example.alphamodel.risorse.Producible;
import org.example.alphamodel.risorse.Resource;
import org.example.alphamodel.risorse.ResourceQuantity;
import org.example.alphamodel.strongbox.Depo;
import org.example.alphamodel.strongbox.DepoBonus;
import org.example.alphamodel.strongbox.StrongBox;

import java.util.ArrayList;
import java.util.List;

public class Player implements SmistamentoProducible , PlayerDispach,SmistamentoLeader {
    private StrongBox strongBox;
    private Path path;
    private Depo depo;
    private int countwhitemarble;
    private List<DevCardCli> devownesd;
    private DevCardCli maybebuyable;
    private Resource optionalresource;
    private DepoBonus depoBonus;


    public Player(StrongBox strongBox, Path path, Depo depo) {
        this.strongBox = strongBox;
        this.path = path;
        this.depo=depo;
        devownesd=new ArrayList<>();
        depoBonus=new DepoBonus();
    }

    @Override
    public void m1(Producible producible) {
        producible.mproducible(this);
    }

    /*
        @Override
        public void m(Producible producible) {
    producible.mproducible(this);
        }

        @Override
        public void m1(Producible producible) {

        }
    */
    @Override
    public void dowithproducible(Resource resource) {
        strongBox.add(resource);
    }

    @Override
    public void dowithproducible(Faith faith) {
path.stepfwd();
    }

public void stampa(){
    int[] s=strongBox.getRicchezza();
    for (int k=0;k<4;k++)
    System.out.println(Resource.values()[k] +"    "+ s[k]);
    System.out.println(path.playerpos);
}

    @Override
    public void genericmarble(Marble emarble) {
emarble.dispatch(this);
    }

    @Override
    public void domarble(MarbleProd emarbleProd) {
        depo.add(emarbleProd.getResource());
    }

    @Override
    public void domarble(MarbleStep emarbleStep) {
        path.stepfwd();
    }
// do nothing
    @Override
    public void domarble(MarbleWhite emarbleWhite) {
        countwhitemarble++;
    }

    @Override
    public void msmistamentoleader(LeaderCard leaderCard) {
        leaderCard.mleaderDispacth(this);
    }

    @Override
    public void doWithLeaderCard(LeaderDiscount leaderDiscount) {
        ResourceQuantity[] res=maybebuyable.getCardCost();
        for(int k=0;k<res.length;k++)
        {
            if (res[k].getResource().ordinal()==leaderDiscount.getDiscount().ordinal())
                if(strongBox.getRicchezza()[res[k].getResource().ordinal()]-1 <res[k].getQuantity() ) {maybebuyable=null;}
            else if(strongBox.getRicchezza()[res[k].getResource().ordinal()] <res[k].getQuantity() ) {maybebuyable=null; }
        }

        if(maybebuyable !=null)
        devownesd.add(maybebuyable);

    }

    @Override
    public void doWithLeaderCard(LeaderExtendedDepo leaderExtendedDepo) {
Resource[] tmp=leaderExtendedDepo.getBonuspace();
depoBonus.setActivate(tmp[0]);

    }

    @Override
    public void doWithLeaderCard(LeaderMarbleWhiteProduction leaderMarbleWhiteProduction) {
    for(;countwhitemarble>=0;countwhitemarble--)
        depo.add(leaderMarbleWhiteProduction.getProduction());
    }

    @Override
    public void doWithLeaderCard(LeaderProductionAndStep leaderProductionAndStep) {
        strongBox.add(optionalresource);
        optionalresource=null;
        path.stepfwd();

    }

    /**
     *
     * @param buffermarble marbles to produce and step forward ,in case of white marble a counter is set if a leaderwhite marble is played in produced resource
     */
    public void setTemporarybuffer(Marble[] buffermarble) {
        countwhitemarble=0;
        for (Marble px:buffermarble)
            this.genericmarble(px);
    }

    public boolean attempttobuydevcard(DevCardCli devCardCli) {
        ResourceQuantity[] res=devCardCli.getCardCost();
        for(int k=0;k<res.length;k++)
        if(strongBox.getRicchezza()[res[k].getResource().ordinal()] <res[k].getQuantity() ) {maybebuyable=devCardCli;return false;}
        {devownesd.add(devCardCli); return true;}

    }

    public List<DevCardCli> getDevownesd() {
        return devownesd;
    }
    public void setOptionalresource(Resource elem){
        this.optionalresource=elem;
    }

    public DepoBonus getDepoBonus(){return depoBonus;}
}