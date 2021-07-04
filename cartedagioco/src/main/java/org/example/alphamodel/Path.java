package org.example.alphamodel;

public class Path {
    int playerpos;

    public Path() {
        playerpos = 0;
    }
    public void stepfwd(){
        playerpos++;
    }

    public int getPlayerpos() {
        return playerpos;
    }
}
