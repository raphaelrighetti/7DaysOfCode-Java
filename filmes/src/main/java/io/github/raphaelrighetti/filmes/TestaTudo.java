package io.github.raphaelrighetti.filmes;

import io.github.raphaelrighetti.filmes.interfaces.Content;
import io.github.raphaelrighetti.filmes.services.*;
import io.github.raphaelrighetti.filmes.services.marvel.MarvelQuadrinhosAPIClient;
import io.github.raphaelrighetti.filmes.services.marvel.MarvelQuadrinhosListGenerator;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class TestaTudo {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("apiKey.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String apiKey = properties.getProperty("apiKey");
        String pvKey = properties.getProperty("pvKeyMarvel");
        String pubKey = properties.getProperty("pubKeyMarvel");

        try {
            String json = new MarvelQuadrinhosAPIClient(pvKey, pubKey).getBody();
            List<? extends Content> list = new MarvelQuadrinhosListGenerator(json).generateList();
            HTMLGenerator.generate(list);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

//        try {
//            String json = new ImdbSeriesAPIClient(apiKey).getBody();
//            List<? extends Content> list = new ImdbSeriesListGenerator(json).generateList();
//            HTMLGenerator.generateImdb(list);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }

//        try {
//            String json = new ImdbFilmesAPIClient(apiKey).getBody();
//            List<? extends Content> list = new ImdbFilmesListGenerator(json).generateList();
//            HTMLGenerator.generateImdb(list);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
