package org.example.alphamodel.parser;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Parsatore p = Parsatore.getInstance("leader.json");
        Gson gson = new Gson();
        LeaderGson[]  leaderGsons= gson.fromJson(p.filotto(), LeaderGson[].class);

    }
}
