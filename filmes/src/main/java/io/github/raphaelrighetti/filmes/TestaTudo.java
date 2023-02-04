package io.github.raphaelrighetti.filmes;

import io.github.raphaelrighetti.filmes.modelos.Catalogo;
import io.github.raphaelrighetti.filmes.services.HTMLGenerator;
import io.github.raphaelrighetti.filmes.services.ImdbApiClient;

import java.io.*;
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

        try {
            String json = new ImdbApiClient(apiKey).getBody();
            Catalogo catalogo = new Catalogo(json);
            HTMLGenerator.generate(catalogo.getFilmes());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
