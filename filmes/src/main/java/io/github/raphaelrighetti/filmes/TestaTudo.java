package io.github.raphaelrighetti.filmes;

import io.github.raphaelrighetti.filmes.interfaces.Content;
import io.github.raphaelrighetti.filmes.services.*;
import io.github.raphaelrighetti.filmes.services.imdb.ImdbFilmesAPIClient;
import io.github.raphaelrighetti.filmes.services.imdb.ImdbFilmesListGenerator;
import io.github.raphaelrighetti.filmes.services.imdb.ImdbSeriesAPIClient;
import io.github.raphaelrighetti.filmes.services.imdb.ImdbSeriesListGenerator;
import io.github.raphaelrighetti.filmes.services.marvel.MarvelQuadrinhosAPIClient;
import io.github.raphaelrighetti.filmes.services.marvel.MarvelQuadrinhosListGenerator;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

//        try {
//            String json = new MarvelQuadrinhosAPIClient(pvKey, pubKey).getBody();
//            List<? extends Content> list = new MarvelQuadrinhosListGenerator(json).generateList();
//            list.sort(Comparator.reverseOrder());
//            HTMLGenerator.generate(list);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }

//        try {
//            String json = new ImdbSeriesAPIClient(apiKey).getBody();
//            List<? extends Content> list = new ImdbSeriesListGenerator(json).generateList();
//            list.sort(Comparator.reverseOrder());
//            HTMLGenerator.generateImdb(list);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }

//        try {
//            String json = new ImdbFilmesAPIClient(apiKey).getBody();
//            List<? extends Content> list = new ImdbFilmesListGenerator(json).generateList();
//            list.sort(Comparator.reverseOrder());
//            HTMLGenerator.generateImdb(list);
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            String jsonFilmes = new ImdbFilmesAPIClient(apiKey).getBody();
            String jsonSeries = new ImdbSeriesAPIClient(apiKey).getBody();
            List<? extends Content> filmes = new ImdbFilmesListGenerator(jsonFilmes).generateList();
            List<? extends Content> series = new ImdbSeriesListGenerator(jsonSeries).generateList();
            List<? extends Content> misturado = Stream.of(filmes, series)
                    .flatMap(Collection::stream).sorted().collect(Collectors.toList());
            HTMLGenerator.generateImdb(misturado);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
