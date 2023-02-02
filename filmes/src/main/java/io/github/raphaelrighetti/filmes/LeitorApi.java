package io.github.raphaelrighetti.filmes;

import io.github.raphaelrighetti.filmes.regex.JsonMatcher;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Properties;

public class LeitorApi {

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
            System.out.println(response.body());
            JsonMatcher jsonMatcher = new JsonMatcher(response.body());
            jsonMatcher.getFilmes().forEach(System.out::println);
            List<String> ranks = jsonMatcher.getRanks();
            for (int i = 0; i < ranks.size(); i++) {
                System.out.println(ranks.get(i) + ", " + i);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
