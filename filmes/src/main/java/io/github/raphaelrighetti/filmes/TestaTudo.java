package io.github.raphaelrighetti.filmes;

import io.github.raphaelrighetti.filmes.modelos.Catalogo;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class TestaTudo {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("apiKey.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" +
                        properties.getProperty("apiKey")))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Catalogo catalogo = new Catalogo(response.body());
            catalogo.getFilmes().forEach(System.out::println);
            System.out.println(catalogo.getFilmes().size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
