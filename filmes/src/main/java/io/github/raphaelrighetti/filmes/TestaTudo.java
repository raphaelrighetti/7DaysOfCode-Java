package io.github.raphaelrighetti.filmes;

import io.github.raphaelrighetti.filmes.modelos.Catalogo;
import io.github.raphaelrighetti.filmes.services.HTMLGenerator;

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
        try (PrintWriter pw = new PrintWriter("index.html")) {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Catalogo catalogo = new Catalogo(response.body());
            pw.write(HTMLGenerator.generate(catalogo.getFilmes()));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
