package org.example.alphamodel.parser;

import java.io.InputStream;

public class Parsatore {

    private String file;
    private static Parsatore instance;

    private Parsatore(String file) {
        this.file=file;
    }


    public static Parsatore getInstance(String file) {
       // if (instance == null)
            instance = new Parsatore(file);
        return instance;
    }


    public String filotto() {
        //development_cards.json
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(file);
        String fileAsString = StreamBuilderForGson.fileforGson(is);
        return fileAsString;
    }
}